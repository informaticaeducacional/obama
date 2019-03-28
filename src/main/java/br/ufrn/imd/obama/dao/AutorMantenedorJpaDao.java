package br.ufrn.imd.obama.dao;

import br.ufrn.imd.obama.dominio.AutorMantenedor;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class AutorMantenedorJpaDao extends EntidadeJpaDao<AutorMantenedor> implements AutorMantenedorDao{

    @Deprecated
    protected AutorMantenedorJpaDao(){
        this(null);
    }

    @Inject
    public AutorMantenedorJpaDao(EntityManager entityManager) {
        super(entityManager, AutorMantenedor.class);
    }
}
