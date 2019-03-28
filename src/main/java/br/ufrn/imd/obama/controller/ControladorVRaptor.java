package br.ufrn.imd.obama.controller;

import br.com.caelum.vraptor.Result;
import br.ufrn.imd.obama.dao.EntidadeDao;
import br.ufrn.imd.obama.dominio.Entidade;

public class ControladorVRaptor<T extends Entidade> extends Controlador {

    protected EntidadeDao<T> dao;

    public ControladorVRaptor(Result resultado, EntidadeDao<T> dao) {
        super(resultado);
        this.dao = dao;
    }


}
