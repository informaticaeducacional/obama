package br.ufrn.imd.obama.dao;

import java.util.List;

import br.ufrn.imd.obama.dominio.Descritor;

public interface DescritorDao extends EntidadeDao<Descritor>{

    List<Descritor> buscarDescritoresListaveis();
    List<Descritor> buscarDescritoresPorNivelETema(int nivelEnsinoId, int temaConteudoId, boolean incluirNaoIdentificado);
    List<Descritor> buscarTodosDescritoresPorNivelETema(int nivelEnsino, int temaConteudo);

    }
