package br.ufrn.imd.obama.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.ufrn.imd.obama.dominio.NivelEnsino;

public class NivelEnsinoJpaDao extends EntidadeJpaDao<NivelEnsino> implements NivelEnsinoDao {

    @Deprecated
    protected NivelEnsinoJpaDao() {
        this(null);
    }

    @Inject
    public NivelEnsinoJpaDao(EntityManager entityManager) {
        super(entityManager, NivelEnsino.class);
    }
}
