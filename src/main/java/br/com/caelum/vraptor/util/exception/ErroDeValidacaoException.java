package br.com.caelum.vraptor.util.exception;

public class ErroDeValidacaoException extends Exception { 
    public ErroDeValidacaoException(String errorMessage) {
        super(errorMessage);
    }
}
