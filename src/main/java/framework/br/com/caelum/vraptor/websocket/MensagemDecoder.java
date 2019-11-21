package framework.br.com.caelum.vraptor.websocket;

import javax.json.Json;
import javax.json.JsonObject;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

import framework.br.com.caelum.vraptor.model.Mensagem;

import java.io.StringReader;

public class MensagemDecoder implements Decoder.Text<Mensagem> {


    @Override
    public Mensagem decode(String jsonMessage) throws DecodeException {
        JsonObject jsonObject = Json.createReader(new StringReader(jsonMessage)).readObject();
        Mensagem mensagem = new Mensagem(jsonObject.getString("atletaID")
                                        ,jsonObject.get("dataEnvio")
                                        ,jsonObject.getString("mensagem"));


        return null;
    }

    @Override
    public boolean willDecode(String s) {
        return false;
    }

    @Override
    public void init(EndpointConfig endpointConfig) {
        System.out.println("init");
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}
