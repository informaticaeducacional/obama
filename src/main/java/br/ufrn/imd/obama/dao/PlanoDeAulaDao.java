package br.ufrn.imd.obama.dao;

import br.ufrn.imd.obama.dominio.PlanoDeAula;
import br.ufrn.imd.obama.dominio.StatusSubmissao;
import br.ufrn.imd.obama.dominio.Usuario;

import java.util.List;

public interface PlanoDeAulaDao extends EntidadeDao<PlanoDeAula>{

    PlanoDeAula buscarPlanoPorId(int idPlanoDeAula);

    List<PlanoDeAula> buscarPlanoPorUsuario(Usuario usuario);

    List<PlanoDeAula> buscarPlanoPorStatus(StatusSubmissao status);

    void buscarComentariosPorPlanoAula(PlanoDeAula planoAula);

    List<PlanoDeAula> buscarTodos();

    List<PlanoDeAula> buscarPlanoPorOA(int idOA);

    PlanoDeAula buscarPlanoPorUsuarioeToken(Usuario usuario, String token);
    
    List<PlanoDeAula> buscarPlanoCompartilhadoComUsuario(Usuario usuario);
}
