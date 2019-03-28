package br.ufrn.imd.obama.controller;

import br.com.caelum.vraptor.Result;

public abstract class Controlador {

    protected final Result resultado;

    public Controlador(Result resultado) {
        this.resultado = resultado;
    }



}
