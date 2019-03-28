package br.ufrn.imd.obama.negocio;

import br.ufrn.imd.obama.dao.UsuarioDao;
import br.ufrn.imd.obama.dominio.Perfil;
import br.ufrn.imd.obama.dominio.StatusUsuario;
import br.ufrn.imd.obama.dominio.TipoCadastro;
import br.ufrn.imd.obama.dominio.Usuario;
import br.ufrn.imd.obama.util.Criptografia;
import br.ufrn.imd.obama.util.GerenciadorEmail;

import javax.inject.Inject;
import java.util.Optional;

public class UsuarioNegocio {

    UsuarioDao usuarioDao;

    @Deprecated
    public UsuarioNegocio(){
        this(null);
    }

    @Inject
    public UsuarioNegocio(UsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }

    public String salvarUsuario(Usuario usuario) {
        String resposta = "";
        if(usuario.getId() > 0) {
            usuarioDao.salvar(usuario);
            resposta = "Usuário atualizado com sucesso.";
        } else if(usuarioDeRS(usuario)){
            usuario.setStatusUsuario(StatusUsuario.ATIVO);
            usuario.setPerfil(Perfil.PADRAO);
            usuarioDao.salvar(usuario);
            resposta = "";
        } else if(!usuario.getSenha().equals(usuario.getConfirmaSenha())){
            resposta = "Confirmação de senha incorreta.";
        } else if(usuarioDao.buscarPorEmail(usuario.getEmail()).isPresent()){
            resposta = "Usuário já está cadastrado. Tente recuperar sua senha.";
        } else {
            String token = Criptografia.criptografar(usuario.getEmail());
            usuario.setToken(token);
            usuario.setStatusUsuario(StatusUsuario.INATIVO);
            usuario.setTipoCadastro(TipoCadastro.PADRAO);
            usuario.setPerfil(Perfil.PADRAO);
            usuarioDao.salvar(usuario);
            enviarEmail(usuario.getEmail(),"OBAMA - Ativação de conta",gerarTextoAtivacao(usuario.getToken()));
            resposta = "Acesse seu email para confirmar o cadastro.";
        }
        return resposta;
    }

    private boolean usuarioDeRS(Usuario usuario) {
        if(usuario.getTipoCadastro() != null) {
            if(usuario.getTipoCadastro().equals(TipoCadastro.FACEBOOK) || usuario.getTipoCadastro().equals(TipoCadastro.GOOGLE)) {
                return true;
            }
        }
        return false;
    }

    private void enviarEmail(String destino, String assunto, String conteudo){
        GerenciadorEmail.enviarEmail(destino,assunto,conteudo);
    }

    private String gerarTextoRecuperacaoSenha(String token) {
        return "Sua conta foi cadastrada com sucesso. Acesse o link para confirmação do e-mail: https://obama.imd.ufrn.br/usuario/recuperarSenha?token=" + token;
    }

    private String gerarTextoAtivacao(String token) {
        return "Sua conta foi cadastrada com sucesso. Acesse o link para confirmação do e-mail: https://obama.imd.ufrn.br/usuario/confirmacao?token=" + token;
    }

    public String enviarEmailRecuperacao(String email) {
        Optional<Usuario> user = usuarioDao.buscarPorEmail(email);
        String resposta = "";
        if(user.isPresent()) {
            Usuario usuario = user.get();
            usuario.setToken(Criptografia.criptografar(usuario.getEmail()));
            usuarioDao.salvar(usuario);
            enviarEmail(usuario.getEmail(),"OBAMA - Recuperação de senha",gerarTextoRecuperacaoSenha(usuario.getToken()));
            resposta = "Email de recuperação enviado com sucesso.";
        } else {
            resposta = "O email não está cadastrado.";
        }
        return resposta;
    }
}
