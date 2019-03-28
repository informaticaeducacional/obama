package br.ufrn.imd.obama.controller;

import java.util.Optional;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.ufrn.imd.obama.anotacoes.ControleDeAcesso;
import br.ufrn.imd.obama.anotacoes.Transacional;
import br.ufrn.imd.obama.dao.UsuarioDao;
import br.ufrn.imd.obama.dominio.Usuario;
import br.ufrn.imd.obama.dominio.UsuarioLogado;
import br.ufrn.imd.obama.negocio.UsuarioNegocio;
import br.ufrn.imd.obama.util.Criptografia;

@Controller
public class LoginController extends Controlador {

    private UsuarioLogado usuarioLogado;

    @Inject
    private UsuarioDao usuarioDao;

    @Inject
    private UsuarioNegocio usuarioNegocio;

    @Deprecated
    protected LoginController() {
        this(null, null);
    }

    @Inject
    public LoginController(Result resultado, UsuarioLogado usuarioLogado) {
        super(resultado);
        this.usuarioLogado = usuarioLogado;
    }

    @ControleDeAcesso
    public void form() {
        resultado.include("redesSociais",true);
        resultado.include("isPaginaInicial",true);
    }

    @Post
    @Transacional
    public void logar(Usuario usuario, boolean redeSocial) {
        Optional<Usuario> user = usuarioDao.buscarPorEmail(usuario.getEmail());
        if (user.isPresent()) {
            if(!redeSocial){
                if (user.get().getSenha().equals(Criptografia.criptografar(usuario.getSenha()))) {
                    usuarioLogado.setUsuario(user.get());
                    resultado.redirectTo(InicioController.class).index();
                } else {
                    resultado.include("mensagem", "Usuario ou senha inválidos.");
                    resultado.redirectTo(this).form();

                }
            } else {
                usuarioLogado.setUsuario(user.get());
                resultado.redirectTo(InicioController.class).index();
            }
        } else {
            if(redeSocial) {
                usuarioNegocio.salvarUsuario(usuario);
                usuarioLogado.setUsuario(usuario);
                resultado.redirectTo(InicioController.class).index();
            } else {
                resultado.include("mensagem", "Esse email ainda não está cadastrado.");
                resultado.redirectTo(this).form();
            }

        }
    }

    @Get("/logout")
    public void logout() {
        this.usuarioLogado.desloga();
        this.resultado.redirectTo(InicioController.class).index();
    }

}
