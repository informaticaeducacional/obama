package br.ufrn.imd.obama.dominio;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;

import br.ufrn.imd.obama.util.Criptografia;

@SessionScoped
public class UsuarioLogado implements Serializable {

	private static final long serialVersionUID = 1L;

	private Usuario usuario;

    private String nomeUsuario;

    public void loga(Usuario usuario) {
        this.usuario = usuario;
    }

    public boolean isLogado() {

        return this.usuario != null;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public String getNomeUsuario() {
        this.nomeUsuario = "";
        if (usuario != null) {
            String name[] = usuario.getNome().split(" ");
            this.nomeUsuario = name[0];
        }
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public boolean isAdministrador() {
        if (usuario != null) {
            if (usuario.getPerfil().equals(Perfil.ADMIN)) {
                return true;
            }
        }
        return false;
    }

    public boolean isRevisor() {
        if (usuario != null) {
            if (usuario.getPerfil().equals(Perfil.ADMIN) || usuario.getPerfil().equals(Perfil.REVISOR)) {
                return true;
            }
        }
        return false;
    }

    public boolean isPadrao() {
        if (usuario != null) {
            if (usuario.getPerfil().equals(Perfil.ADMIN)
                    || usuario.getPerfil().equals(Perfil.REVISOR) ||  usuario.getPerfil().equals(Perfil.PADRAO)) {
                return true;
            }
        }
        return false;
    }

    public void desloga() {
        this.usuario = null;
    }

    public String getToken() {
        return Criptografia.criptografar(usuario.getEmail());
    }
}
