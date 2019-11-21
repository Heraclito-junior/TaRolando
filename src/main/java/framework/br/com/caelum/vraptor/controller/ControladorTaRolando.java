package framework.br.com.caelum.vraptor.controller;

import br.com.caelum.vraptor.Result;
import framework.br.com.caelum.vraptor.model.Entidade;

public class ControladorTaRolando<T extends Entidade> extends Controlador {

    public ControladorTaRolando(Result resultado) {
        super(resultado);
    }


}
