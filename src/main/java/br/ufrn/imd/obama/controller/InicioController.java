package br.ufrn.imd.obama.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;

@Controller
public class InicioController extends Controlador {

    @Deprecated
    protected InicioController(){
        this(null);
    }

    @Inject
    public InicioController(Result resultado) {
        super(resultado);
    }

    @Path("")
    public void index() {
    	resultado.include("isPaginaInicial", true);
    }
        
    public void equipe() {

    }
    
    public void publicacoes() {

    }

    public void oauth() {

    }

}
