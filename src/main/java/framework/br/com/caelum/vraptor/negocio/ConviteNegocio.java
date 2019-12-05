package framework.br.com.caelum.vraptor.negocio;

import java.util.List;

public interface ConviteNegocio<T> {


    public void aceitar(Long id); 
    

    public void rejeitar(Long id);

    public void remover(Long id);
    
    public List<T> meusConvites();

    public List<T> meusConvitesEnviados();


}
