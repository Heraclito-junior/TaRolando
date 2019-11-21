package framework.br.com.caelum.vraptor.anotacoes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import framework.br.com.caelum.vraptor.model.TipoAtleta;

@Retention(RetentionPolicy.RUNTIME) @Target({ElementType.TYPE, ElementType.METHOD})
public @interface Seguranca {
    TipoAtleta tipoUsuario() default TipoAtleta.ATLETA;

}
