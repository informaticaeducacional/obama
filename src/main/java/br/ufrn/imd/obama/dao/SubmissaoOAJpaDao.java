package br.ufrn.imd.obama.dao;

import br.ufrn.imd.obama.dominio.SugestaoOA;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class SubmissaoOAJpaDao extends EntidadeJpaDao<SugestaoOA> implements SubmissaoOADao {

    protected SubmissaoOAJpaDao(){
        this(null);
    }

    @Inject
    public SubmissaoOAJpaDao(EntityManager entityManager) {
        super(entityManager, SugestaoOA.class);
    }

}
