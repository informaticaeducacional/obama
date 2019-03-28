package br.ufrn.imd.obama.controller;

import java.util.Optional;

import javax.inject.Inject;

import br.ufrn.imd.obama.anotacoes.Seguranca;
import br.ufrn.imd.obama.dominio.Perfil;
import com.google.gson.JsonObject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.ufrn.imd.obama.anotacoes.Transacional;
import br.ufrn.imd.obama.dao.EntidadeDao;
import br.ufrn.imd.obama.dao.UsuarioDao;
import br.ufrn.imd.obama.dominio.StatusUsuario;
import br.ufrn.imd.obama.dominio.Usuario;
import br.ufrn.imd.obama.negocio.UsuarioNegocio;
import br.ufrn.imd.obama.util.Criptografia;

@Controller
public class UsuarioController extends ControladorVRaptor<Usuario> {

    private UsuarioNegocio usuarioNegocio;
    private UsuarioDao usuarioDao;

    @Deprecated
    protected UsuarioController() {
        this(null, null, null, null);
    }

    @Inject
    public UsuarioController(Result resultado, EntidadeDao<Usuario> dao,
                             UsuarioNegocio usuarioNegocio, UsuarioDao usuarioDao) {
        super(resultado, dao);
        this.usuarioNegocio = usuarioNegocio;
        this.usuarioDao = usuarioDao;
    }

    @Transacional
    @Post
    public void salvar(Usuario usuario) {
        String mensagem = this.usuarioNegocio.salvarUsuario(usuario);
        JsonObject jsonResposta = new JsonObject();
        jsonResposta.addProperty("mensagem", mensagem);
        resultado.use(Results.json()).withoutRoot().from(jsonResposta).serialize();
    }

    @Transacional
    public void confirmacao(String token) {
        if (token != null) {
            Optional<Usuario> usuario = usuarioDao.buscarPorToken(token);
            if (usuario.isPresent()) {
                usuario.get().setStatusUsuario(StatusUsuario.ATIVO);
                usuario.get().setToken("");
                usuarioDao.salvar(usuario.get());
                resultado.include("mensagem", "Conta ativada com sucesso.");
            }
        } else {
        }
        resultado.redirectTo(LoginController.class).form();
    }

    public void esqueciMinhaSenha() {

    }

    @Get
    public void recuperarSenha(String token) {
        Optional<Usuario> user = usuarioDao.buscarPorToken(token);
        if (user.isPresent()) {
            resultado.include("usuario", user.get());
        } else {
            resultado.include("mensagem", "Erro ao tentar acessar link de recuperação de senha.");
            resultado.redirectTo(LoginController.class).form();
        }

    }

    @Transacional
    @Post
    public void trocarSenha(Usuario usuario, String senha, String confirmaSenha) {
        Usuario usuarioBanco = usuarioDao.buscarPorId(usuario.getId());
        if (senha.equals(confirmaSenha)) {
            senha = Criptografia.criptografar(senha);
            usuarioBanco.setSenha(senha);
            usuarioBanco.setToken("");
            usuarioDao.salvar(usuario);
            resultado.include("mensagem", "Senha recuperada com sucesso.");
            resultado.redirectTo(LoginController.class).form();
        } else {
            resultado.include("usuario", usuarioBanco);
            resultado.include("mensagem", "Verifique se a senha de confirmação está correta.");
            resultado.redirectTo(UsuarioController.class).recuperarSenha("");
        }
    }

    @Get
    public void ativarConta(String token) {
        Optional<Usuario> user = usuarioDao.buscarPorToken(token);
        String resposta = "";
        if (user.isPresent()) {
            Usuario usuario = user.get();
            usuario.setToken("");
            usuario.setStatusUsuario(StatusUsuario.ATIVO);
            usuarioDao.salvar(usuario);
            resposta = "Login ativado com sucesso.";
        } else {
            resposta = "Falha na requisição. Verifique o link de recuperação enviado ao email.";
        }
        resultado.include("mensagem", resposta);
        resultado.redirectTo(LoginController.class).form();
    }

    @Post
    @Transacional
    public void solicitarNovaSenha(String email) {
        String resposta = usuarioNegocio.enviarEmailRecuperacao(email);
        resultado.include("mensagem", resposta);
        resultado.redirectTo(LoginController.class).form();
    }

    public void form() {

    }

    @Seguranca(perfil = Perfil.ADMIN)
    public void lista() {
        resultado.include("usuarios",dao.listar());
    }

    @Post
    @Transacional
    public void alterarPerfil(int id, Perfil perfil){
        if(id > 0) {
            Usuario usuario = dao.buscarPorId(id);
            usuario.setPerfil(perfil);
            usuarioDao.salvar(usuario);
            resultado.include("usuarios",usuarioDao.listar());
            resultado.redirectTo(this).lista();
        }
    }
}