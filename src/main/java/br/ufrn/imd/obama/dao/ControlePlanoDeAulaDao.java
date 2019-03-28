package br.ufrn.imd.obama.dao;

import br.ufrn.imd.obama.dominio.ControlePlanoDeAula;

import java.util.Optional;

public interface ControlePlanoDeAulaDao extends EntidadeDao<ControlePlanoDeAula>{

    Optional<ControlePlanoDeAula> buscarPelaToken(String token);
}
