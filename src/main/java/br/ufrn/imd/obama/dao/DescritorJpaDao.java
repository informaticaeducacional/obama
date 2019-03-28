package br.ufrn.imd.obama.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.ufrn.imd.obama.dominio.Descritor;

public class DescritorJpaDao extends EntidadeJpaDao<Descritor> implements DescritorDao {

    @Deprecated
    protected DescritorJpaDao(){
        this(null);
    }

    @Inject
    public DescritorJpaDao(EntityManager entityManager) {
        super(entityManager, Descritor.class);
    }

    @SuppressWarnings("unchecked")
	@Override
    public List<Descritor> buscarDescritoresListaveis() {
        Query query = manager.createQuery("SELECT d FROM Descritor d WHERE d.codigo != 'D0'");
        return query.getResultList();
    }

    @SuppressWarnings("unchecked")
	@Override
    public List<Descritor> buscarDescritoresPorNivelETema(int nivelEnsino, int temaConteudo, boolean incluirNaoIdentificado) {    	
        StringBuilder jpql = new StringBuilder("SELECT d FROM Descritor d WHERE 1=1 ");
        if(incluirNaoIdentificado) {
        	jpql.append("AND d.codigo != 'D0' ");
        }
        if(nivelEnsino > 0) {
            jpql.append("AND d.nivelEnsino.id = :idNivelEnsino ");
        } 
        if(temaConteudo > 0) {
            jpql.append("AND d.temaConteudo.id = :idTemaConteudo ");
        }
        
        Query query = manager.createQuery(jpql.toString());
        
        if(nivelEnsino > 0) {
            query.setParameter("idNivelEnsino", nivelEnsino);
        } 
        if(temaConteudo > 0) {
        	query.setParameter("idTemaConteudo", temaConteudo);
        }
        return query.getResultList();
    }

	@Override
    public List<Descritor> buscarTodosDescritoresPorNivelETema(int nivelEnsino, int temaConteudo) {
        return buscarDescritoresPorNivelETema(nivelEnsino, temaConteudo, true);
    }
}
