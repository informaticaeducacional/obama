package br.ufrn.imd.obama.dao;

import br.ufrn.imd.obama.dominio.ControlePlanoDeAula;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Optional;

public class ControlePlanoDeAulaJpaDao extends EntidadeJpaDao<ControlePlanoDeAula> implements ControlePlanoDeAulaDao {

    @Deprecated
    protected ControlePlanoDeAulaJpaDao(){
        this(null);
    }

    @Inject
    public ControlePlanoDeAulaJpaDao(EntityManager entityManager) {
        super(entityManager, ControlePlanoDeAula.class);
    }

    @Override
    public Optional<ControlePlanoDeAula> buscarPelaToken(String token) {
        Query query = manager.createQuery("SELECT c FROM ControlePlanoDeAula c WHERE c.token = :token");
        query.setParameter("token",token);
        query.setMaxResults(1);
        return query.getResultList().stream().findFirst();
    }
}
