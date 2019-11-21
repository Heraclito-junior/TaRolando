package framework.br.com.caelum.vraptor.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import framework.br.com.caelum.vraptor.model.AtletaLogado;
import framework.br.com.caelum.vraptor.model.Chat;
import framework.br.com.caelum.vraptor.model.Mensagem;
import framework.br.com.caelum.vraptor.negocio.AtletaNegocio;
import framework.br.com.caelum.vraptor.negocio.ChatNegocio;

import javax.inject.Inject;
import java.time.LocalDate;

@Controller
public class ChatController extends ControladorTaRolando<Chat> {

    @Inject
    private ChatNegocio chatNegocio;

    @Inject
    private AtletaNegocio atletaNegocio;

    private AtletaLogado atletaLogado;

    public ChatController() { this(null, null); }

    @Inject
    public ChatController(Result resultado, AtletaLogado atletaLogado) {
        super(resultado);
        this.chatNegocio = chatNegocio;
        this.atletaLogado = atletaLogado;
        this.atletaNegocio = atletaNegocio;
    }


    @Get
    public void chat(Long id){
        resultado.include("atletaLogado", atletaLogado);
        resultado.include("chat", chatNegocio.buscarChatPorId(id));
//        resultado.include("mensagens", chatNegocio.listar());
    }

    public void createChat() {
        Chat chat = new Chat();

    }

    @Post
    public void sendMessage(Mensagem mensagem, Long idChat) {
//        Mensagem mensagem = new Mensagem();
        mensagem.setDataEnvio(LocalDate.now());

        Chat chat = chatNegocio.buscarChatPorId(idChat);
        mensagem.setChat(chat);
        chat.getMensagens().add(mensagem);
        chatNegocio.salvar(chat);

        resultado.include("atletaLogado", atletaLogado);
        resultado.include("chat", chatNegocio.buscarChatPorId(chat.getId()));
        resultado.of(this).chat(idChat);
    }

    @Post
    public void salvar(Chat chat) {
        chatNegocio.salvar(chat);
    }

    public void editar() {

    }

    public void remover(Long id) {

    }

    public void listar() {

    }
}
