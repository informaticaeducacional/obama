package br.ufrn.imd.obama.anotacoes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by samue on 10/09/2017.
 */
@Retention(RetentionPolicy.RUNTIME) @Target(ElementType.METHOD) public @interface Transacional {
}

