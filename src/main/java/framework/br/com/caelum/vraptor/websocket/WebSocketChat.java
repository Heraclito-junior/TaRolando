package framework.br.com.caelum.vraptor.websocket;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@ServerEndpoint("/websocket")
public class WebSocketChat {

//    private static Map<String, Session> sMap = new HashMap<String, Session>();
    private static Set<Session> clients = Collections.synchronizedSet(new HashSet<Session>());

//    private ChatController chatController = new ChatController();

    @OnMessage
    public void onMessage(String message, Session session) throws IOException, InterruptedException {

        String[] msgSplit = message.split("-", 3);
//        atletaNegocio.buscarAtletaPorId(Long.parseLong(msgSplit[0]));
//        Mensagem mensagem = new Mensagem();
//        mensagem.setMensagem(msgSplit[2]);
        System.out.println(msgSplit[0]+ "..."+msgSplit[1]+"..."+msgSplit[2]);

        try {
            synchronized (clients) {
                for(Session client : clients) {
                    if (client.isOpen()) {
                        System.out.println("mensagem enviada para " + client.getId());
                        client.getBasicRemote().sendText(message);
                    } else {
                        clients.remove(client);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }



//        Map<String, List<String>> params = session.getRequestParameterMap();
//
//        if (params.get("id").get(0) != null) {
//            Chat chat = chatNegocio.buscarChatPorId(Long.parseLong(params.get("id").get(0)));
//            System.out.println(chat.getId());
//        }
//
//        session.getRequestParameterMap().get("atletaLogado");
//        session.getRequestParameterMap().get("idChat");
//        session.getRequestParameterMap().get("");
//

//        try {
//            for (String key : sMap.keySet()) {
//
//                Session s = sMap.get(key);
//
//                if (s.isOpen()) {
//                    System.out.println("mensagem enviada para " + s.getId());
//                    s.getBasicRemote().sendText(message);
//                } else {
//                    sMap.remove(key);
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    @OnOpen
    public void onOpen(Session session) {
        System.out.println("Client "+ session.getId() +" connected");
        clients.add(session);
//        sMap.put(session.getId(), session);
    }

    @OnClose
    public void onClose(Session session) {
        System.out.println("Client " + session.getId() + " left");
        clients.remove(session);
    }

    @OnError
    public void onError(Throwable t) {
        System.out.println("onError::" + t.getMessage());
    }
}
