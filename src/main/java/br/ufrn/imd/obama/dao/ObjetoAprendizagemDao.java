package br.ufrn.imd.obama.dao;

import br.ufrn.imd.obama.dominio.ObjetoAprendizagem;

import java.util.List;
import java.util.Set;

public interface ObjetoAprendizagemDao extends EntidadeDao<ObjetoAprendizagem>{
    List<ObjetoAprendizagem> buscarOA(String texto, int idNivelEnsino, int idTemaConteudo, int idDescritor, int idTipoVisualizacao);
    Set<ObjetoAprendizagem> todosOAs();
    public List<ObjetoAprendizagem> getListaOrdenada();
}
