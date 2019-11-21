package framework.br.com.caelum.vraptor.negocio;

import framework.br.com.caelum.vraptor.anotacoes.Transacional;
import framework.br.com.caelum.vraptor.dao.ChatDAO;
import framework.br.com.caelum.vraptor.model.Chat;

import javax.inject.Inject;
import java.util.List;

public class ChatNegocio {

    private ChatDAO chatDAO;

    @Deprecated
    public ChatNegocio() { this(null); }

    @Inject
    public ChatNegocio(ChatDAO chatDAO) {
        this.chatDAO = chatDAO;
    }

    @Transacional
    public void salvar(Chat chat) {
        chatDAO.salvar(chat);
    }

    public void editar(Long id) {

    }

    public void remover() {

    }

    public List<Chat> listar() {
        return (List<Chat>) chatDAO.listar();
    }

    public Chat buscarChatPorId(Long id) {
        Chat chat = chatDAO.buscarPorId(id);
        return chat;
    }
}
