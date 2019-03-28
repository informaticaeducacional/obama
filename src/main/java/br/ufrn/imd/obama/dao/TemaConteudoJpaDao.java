package br.ufrn.imd.obama.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.ufrn.imd.obama.dominio.TemaConteudo;

public class TemaConteudoJpaDao extends EntidadeJpaDao<TemaConteudo> implements TemaConteudoDao{

    @Deprecated
    protected TemaConteudoJpaDao(){
        this(null);
    }

    @Inject
    public TemaConteudoJpaDao(EntityManager entityManager) {
        super(entityManager, TemaConteudo.class);
    }
}
