package br.com.caelum.vraptor.controller;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.model.Entidade;

public class ControladorTaRolando<T extends Entidade> extends Controlador {

    public ControladorTaRolando(Result resultado) {
        super(resultado);
    }


}
