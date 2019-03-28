package br.ufrn.imd.obama.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.ufrn.imd.obama.dominio.Perfil;
import br.ufrn.imd.obama.dominio.PlanoDeAula;
import br.ufrn.imd.obama.dominio.StatusSubmissao;
import br.ufrn.imd.obama.dominio.Usuario;

public class PlanoDeAulaJpaDao extends EntidadeJpaDao<PlanoDeAula> implements PlanoDeAulaDao {

    @Deprecated
    protected PlanoDeAulaJpaDao(){
        this(null);
    }

    @Inject
    public PlanoDeAulaJpaDao(EntityManager entityManager) {
        super(entityManager, PlanoDeAula.class);
    }

    @Override
    public PlanoDeAula buscarPlanoPorId(int idPlanoDeAula) {
        PlanoDeAula planoDeAula =  manager.find(PlanoDeAula.class, idPlanoDeAula);
        return planoDeAula;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<PlanoDeAula> buscarPlanoPorUsuario(Usuario usuario) {
        StringBuilder hql = new StringBuilder("SELECT DISTINCT plano FROM PlanoDeAula plano LEFT JOIN plano.objetosAprendizagem WHERE plano.autor.id = :idUsuario ");
//        StringBuilder hql = new StringBuilder("SELECT DISTINCT plano FROM PlanoDeAula plano LEFT JOIN plano.objetosAprendizagem WHERE plano.autor.id = :idUsuario ");
        if(usuario.getPerfil().equals(Perfil.PADRAO)) {
            hql.append("AND plano.status != :statusRemovido");
        }

        Query query = manager.createQuery(hql.toString());
        if(usuario.getPerfil().equals(Perfil.PADRAO)) {
            query.setParameter("statusRemovido", StatusSubmissao.REMOVIDO.getId());
        }
        query.setParameter("idUsuario", usuario.getId());
        return query.getResultList();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<PlanoDeAula> buscarPlanoPorOA(int idOA) {
        StringBuilder hql = new StringBuilder("SELECT DISTINCT plano FROM PlanoDeAula plano LEFT JOIN plano.objetosAprendizagem WHERE plano.ojetosAprendizagmanager.id = :idOA ");
        hql.append("AND plano.status != 5 ");

        Query query = manager.createQuery(hql.toString());
        query.setParameter("idOA", idOA);

        return query.getResultList();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<PlanoDeAula> buscarPlanoPorStatus(StatusSubmissao status) {
        StringBuilder hql = new StringBuilder("SELECT DISTINCT plano FROM PlanoDeAula plano LEFT JOIN plano.objetosAprendizagem WHERE plano.status = :idStatus ");
        Query query = manager.createQuery(hql.toString());
        query.setParameter("idStatus", status.getId());
        return query.getResultList();
    }

    @Override
    public void buscarComentariosPorPlanoAula(PlanoDeAula planoAula) {
        manager.merge(planoAula);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<PlanoDeAula> buscarTodos() {
        StringBuilder hql = new StringBuilder("SELECT DISTINCT plano FROM PlanoDeAula plano ");
        hql.append("WHERE plano.status != 5  ORDER BY plano.dataCadastro ");
        Query query = manager.createQuery(hql.toString());
        return query.getResultList();
    }

    public PlanoDeAula buscarPlanoPorToke(String token) {
        StringBuilder hql = new StringBuilder("SELECT DISTINCT plano FROM PlanoDeAula plano WHERE plano.token LIKE :tokenPlano ");
        hql.append("AND plano.status != 5 ");
        Query query = manager.createQuery(hql.toString());
        query.setParameter("tokenPlano", token);

        return (PlanoDeAula) query.getSingleResult();
    }

    @Override
    public PlanoDeAula buscarPlanoPorUsuarioeToken(Usuario usuario, String token) {
        StringBuilder hql = new StringBuilder("SELECT DISTINCT plano FROM PlanoDeAula plano LEFT JOIN plano.coautores coautor LEFT JOIN plano.objetosAprendizagem WHERE (plano.autor.id = :idUsuario OR coautor.id = :idUsuario) AND plano.token LIKE :token ");
        PlanoDeAula planoDeAulaEncontrado = null;
        if(usuario != null) {
	        if(usuario.getPerfil().equals(Perfil.PADRAO)) {
	            hql.append("AND plano.status != :statusRemovido");
	        }
	        Query query = manager.createQuery(hql.toString());
	        if(usuario.getPerfil().equals(Perfil.PADRAO)) {
	            query.setParameter("statusRemovido", StatusSubmissao.REMOVIDO.getId());
	        }
	        query.setParameter("idUsuario", usuario.getId());
	        query.setParameter("token", token);
	        try {
	            planoDeAulaEncontrado = (PlanoDeAula)query.getSingleResult();
	        } catch (Exception e) {
	            return null;
	        }
        } 
        return planoDeAulaEncontrado;
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<PlanoDeAula> buscarPlanoCompartilhadoComUsuario(Usuario usuario) {
		StringBuilder hql = new StringBuilder("SELECT DISTINCT plano FROM PlanoDeAula plano LEFT JOIN plano.coautores coautor LEFT JOIN plano.objetosAprendizagem WHERE coautor.id = :idUsuario ");
		if(usuario.getPerfil().equals(Perfil.PADRAO)) {
			hql.append("AND plano.status != :statusRemovido");
		}
		
		Query query = manager.createQuery(hql.toString());
		if(usuario.getPerfil().equals(Perfil.PADRAO)) {
			query.setParameter("statusRemovido", StatusSubmissao.REMOVIDO.getId());
		}
		query.setParameter("idUsuario", usuario.getId());
		return query.getResultList();
	}
}
