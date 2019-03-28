package br.ufrn.imd.obama.dao;

import java.util.List;

import br.ufrn.imd.obama.dominio.Entidade;

public interface EntidadeDao<T extends Entidade> {

    T buscarPorId(int id);
    T salvar(T entidade);
    void remover(T entidade);
    List<T> listar();
    
}