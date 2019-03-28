package br.ufrn.imd.obama.anotacoes;

import br.ufrn.imd.obama.dominio.Perfil;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) @Target({ElementType.TYPE, ElementType.METHOD})
public @interface Seguranca {
        Perfil perfil() default Perfil.PADRAO;
}
