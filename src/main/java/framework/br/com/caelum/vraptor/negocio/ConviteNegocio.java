package framework.br.com.caelum.vraptor.negocio;

import java.util.List;

public interface ConviteNegocio<T> {


    public List<T> meusConvites();

    public List<T> meusConvitesEnviados();


}
