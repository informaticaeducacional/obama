package br.ufrn.imd.obama.interceptors;

import br.com.caelum.vraptor.Accepts;
import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.interceptor.SimpleInterceptorStack;
import br.com.caelum.vraptor.view.Results;
import br.ufrn.imd.obama.anotacoes.ControleDeAcesso;
import br.ufrn.imd.obama.controller.LoginController;
import br.ufrn.imd.obama.dominio.UsuarioLogado;

import javax.inject.Inject;

@Intercepts
public class AutenticacaoInterceptor {

    private UsuarioLogado usuario;
    private Result resultado;

    @Inject
    public AutenticacaoInterceptor(UsuarioLogado usuarioLogado, Result resultado) {
        this.usuario = usuarioLogado;
        this.resultado = resultado;
    }

    @Deprecated
    AutenticacaoInterceptor(){}

    @AroundCall
    public void autentica(SimpleInterceptorStack stack){
        if(usuario.isLogado()){
            resultado.include("usuarioLogado",usuario);
            resultado.use(Results.http()).sendError(403, "Usuário não autorizado");
        } else {
            stack.next();
        }
    }

    @Accepts
    public boolean ehRestrito(ControllerMethod method){
        return method.getController().getType().equals(LoginController.class)
                && method.getMethod().getAnnotation(ControleDeAcesso.class) != null;
    }

}
