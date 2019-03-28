package br.ufrn.imd.obama.dao.util;

public class ObjetoAprendizagemDAOUtil {
	public String montarConsultaComTodosParametros(String texto,int idNivelEnsino, int idTemaConteudo, int idDescritor, int idTipoObjeto) {
		String[] termosDoTexto = (texto == null || texto.equals(""))? new String[]{}: texto.split(" ");
		StringBuilder hql = new StringBuilder("SELECT DISTINCT oa FROM ObjetoAprendizagem oa ");
		hql.append("INNER JOIN oa.descritores d ");
		hql.append("LEFT JOIN oa.autoresMantenedores a ");
//		hql.append("LEFT JOIN oa.tipoObjeto to ");
		
		hql.append("WHERE oa.ativo = true ");

		if(termosDoTexto.length > 0) {
			//Busca textual por qualquer informação do OA
			hql.append("AND ( 2=1 ");
			boolean existeOutraCondicao = false;
			for(int i = 0; i < termosDoTexto.length; i ++) {
				if(termosDoTexto[i].length() > 3 || isTermoRelevante(termosDoTexto[i])) {
					hql.append("OR UPPER(TRANSLATE(oa.nome,'ÀÁáàÉÈéèÍíÓóÒòÚúÇç','AAaaEEeeIiOoOoUuCc')) LIKE upper(TRANSLATE(").append(":termo"+i+",'ÀÁáàÉÈéèÍíÓóÒòÚúÇç','AAaaEEeeIiOoOoUuCc')) ");
//					hql.append("OR UPPER(TRANSLATE(oa.descricao,'ÀÁáàÉÈéèÍíÓóÒòÚú','AAaaEEeeIiOoOoUu')) LIKE upper(TRANSLATE(").append(":termo"+i+",'ÀÁáàÉÈéèÍíÓóÒòÚú','AAaaEEeeIiOoOoUu')) ");
					hql.append("OR UPPER(TRANSLATE(d.descricao,'ÀÁáàÉÈéèÍíÓóÒòÚúÇç','AAaaEEeeIiOoOoUuCc')) LIKE upper(TRANSLATE(").append(":termo"+i+",'ÀÁáàÉÈéèÍíÓóÒòÚúÇç','AAaaEEeeIiOoOoUuCc')) ");
//					hql.append("OR UPPER(TRANSLATE(d.nivelEnsino.denominacao,'ÀÁáàÉÈéèÍíÓóÒòÚú','AAaaEEeeIiOoOoUu')) LIKE upper(TRANSLATE(").append(":termo"+i+",'ÀÁáàÉÈéèÍíÓóÒòÚú','AAaaEEeeIiOoOoUu')) ");
//					hql.append("OR UPPER(TRANSLATE(d.temaConteudo.denominacao,'ÀÁáàÉÈéèÍíÓóÒòÚú','AAaaEEeeIiOoOoUu')) LIKE upper(TRANSLATE(").append(":termo"+i+",'ÀÁáàÉÈéèÍíÓóÒòÚú','AAaaEEeeIiOoOoUu')) ");
					existeOutraCondicao = true;
				}
			}
			hql.append(") ");
		} 	
		
		if(idNivelEnsino > 0) {
			hql.append("AND :nivelEnsino = d.nivelEnsino.id ");
		}
		
		if(idTemaConteudo > 0) {
			hql.append("AND :temaConteudo = d.temaConteudo.id ");
		}
		
		if(idDescritor > 0) {
			hql.append("AND :descritor = d.id ");
		}
		
		//TODO Finalizar o termo.
		if(idTipoObjeto > 0) {
			hql.append("AND oa.tipoVisualizacao = :tipovisualizacao ");
		}
		
		return hql.toString();
	}

	public static boolean isTermoRelevante(String termo) {
		boolean termoRelevante = true;
		String[] termosIrrelevante = {"o", "os", "a", "as", "que", "um", "uns", "uma", "umas", "de", "do", "dos", "das", "da"};
		for (int i = 0; i < termosIrrelevante.length; i++) {
			if(termo.toLowerCase().equals(termosIrrelevante[i])) {
				termoRelevante = false;
				break;
			}
		}
		return termoRelevante;
	}
}
