package br.ufrn.imd.obama.dao;

import java.util.Optional;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.ufrn.imd.obama.dominio.Usuario;
public class UsuarioJpaDao extends EntidadeJpaDao<Usuario> implements UsuarioDao{

    @Deprecated
    protected UsuarioJpaDao() {
        this(null);
    }

    @Inject
    public UsuarioJpaDao(EntityManager entityManager) {
        super(entityManager, Usuario.class);
    }

    @Override
    public Optional<Usuario> buscarPorEmail(String email) {
        Query query = manager.createQuery("SELECT u FROM Usuario u where u.email= :email");
        query.setParameter("email",email);
        query.setMaxResults(1);
        return query.getResultList().stream().findFirst();
    }

    @Override
    public Optional<Usuario> buscarPorToken(String token) {
        Query query = manager.createQuery("SELECT u FROM Usuario u where u.token= :token");
        query.setParameter("token",token);
        query.setMaxResults(1);
        return query.getResultList().stream().findFirst();
    }
}


