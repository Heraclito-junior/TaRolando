package br.com.caelum.vraptor.anotacoes;

import br.com.caelum.vraptor.model.TipoAtleta;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) @Target({ElementType.TYPE, ElementType.METHOD})
public @interface Seguranca {
    TipoAtleta tipoUsuario() default TipoAtleta.ATLETA;

}
