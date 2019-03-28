package br.ufrn.imd.obama.dao;

import br.ufrn.imd.obama.dominio.Usuario;

import java.util.Optional;

public interface UsuarioDao extends EntidadeDao<Usuario> {
    Optional<Usuario> buscarPorEmail(String email);
    Optional<Usuario> buscarPorToken(String token);
}
