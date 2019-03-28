package br.ufrn.imd.obama.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.ufrn.imd.obama.dominio.TipoObjeto;

public class TipoObjetoJpaDao extends EntidadeJpaDao<TipoObjeto> implements TipoObjetoDao {

    @Deprecated
    protected TipoObjetoJpaDao() {
        this(null);
    }

    @Inject
    public TipoObjetoJpaDao(EntityManager entityManager) {
        super(entityManager,TipoObjeto.class);
    }
}
