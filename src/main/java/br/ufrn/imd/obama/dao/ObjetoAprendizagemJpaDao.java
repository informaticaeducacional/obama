package br.ufrn.imd.obama.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.ufrn.imd.obama.dao.util.ObjetoAprendizagemDAOUtil;
import br.ufrn.imd.obama.dominio.ObjetoAprendizagem;
import br.ufrn.imd.obama.util.StemmerObama;

public class ObjetoAprendizagemJpaDao extends EntidadeJpaDao<ObjetoAprendizagem> implements ObjetoAprendizagemDao {

    @Inject
    private ObjetoAprendizagemDAOUtil objetoAprendizagemDAOUtil;

    @Deprecated
    protected ObjetoAprendizagemJpaDao(){
        this(null);
    }

    @Inject
    public ObjetoAprendizagemJpaDao(EntityManager entityManager) {
        super(entityManager, ObjetoAprendizagem.class);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<ObjetoAprendizagem> buscarOA(String texto, int idNivelEnsino, int idTemaConteudo, int idDescritor, int idTipoVisualizacao) {

        String hql = objetoAprendizagemDAOUtil.montarConsultaComTodosParametros(texto, idNivelEnsino, idTemaConteudo, idDescritor, idTipoVisualizacao);

        Query query = manager.createQuery(hql.toString());

        String[] termosDoTexto = texto == null ? new String[]{}: texto.split(" ");

        /**
         * Verifica se há texto de busca. Se houver os termos serão tratados para otimizar a busca
         * e o parametro 'termo' é setado na query
         * */
        if(!(termosDoTexto.length == 1 && termosDoTexto[0].isEmpty())) {
            for(int i = 0; i < termosDoTexto.length; i++) {
                if(!termosDoTexto[i].isEmpty() && ObjetoAprendizagemDAOUtil.isTermoRelevante(termosDoTexto[i])) {
                    StemmerObama stemmer = new StemmerObama();
                    String termo = stemmer.stem(termosDoTexto[i]);
                    query.setParameter("termo"+i, "%"+termo+"%");
                }
            }
        }

        if(idNivelEnsino > 0) {
            query.setParameter("nivelEnsino", idNivelEnsino);
        }

        if(idTemaConteudo > 0) {
            query.setParameter("temaConteudo", idTemaConteudo);
        }

        if(idDescritor > 0) {
            query.setParameter("descritor", idDescritor);
        }

        if(idTipoVisualizacao > 0) {
            query.setParameter("tipovisualizacao", idTipoVisualizacao);
        }

        return query.getResultList();
    }

    @Override
    public Set<ObjetoAprendizagem> todosOAs() {
        Set<ObjetoAprendizagem> objetos = new HashSet<>();
        @SuppressWarnings("unchecked")
		List<ObjetoAprendizagem> listaOA = manager.createQuery("SELECT o FROM ObjetoAprendizagem o WHERE o.ativo = true").getResultList();
        if(listaOA != null) {
            objetos.addAll(listaOA);
        }
        return objetos;
    }
    
	@Override
	@SuppressWarnings("unchecked")
	public List<ObjetoAprendizagem> getListaOrdenada() {
		Query query = manager.createQuery("SELECT o FROM ObjetoAprendizagem o ORDER BY o.nome");
		return query.getResultList();
	}
}
