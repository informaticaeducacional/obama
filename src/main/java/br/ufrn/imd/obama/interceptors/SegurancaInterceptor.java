package br.ufrn.imd.obama.interceptors;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import br.com.caelum.vraptor.Accepts;
import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.interceptor.SimpleInterceptorStack;
import br.com.caelum.vraptor.view.Results;
import br.ufrn.imd.obama.anotacoes.Seguranca;
import br.ufrn.imd.obama.controller.LoginController;
import br.ufrn.imd.obama.dominio.Perfil;
import br.ufrn.imd.obama.dominio.UsuarioLogado;

@Intercepts(after = AutenticacaoInterceptor.class)
public class SegurancaInterceptor {

    private Result resultado;
    private UsuarioLogado usuarioLogado;

    @Inject
    public SegurancaInterceptor(Result resultado, UsuarioLogado usuarioLogado) {
        this.resultado = resultado;
        this.usuarioLogado = usuarioLogado;
    }

    @Deprecated SegurancaInterceptor(){}

    @Accepts
    public boolean verificarSegurança(ControllerMethod method){
        return !method.getController().getType().equals(LoginController.class);
    }

    @AroundCall
    public void autoriza(SimpleInterceptorStack stack, ControllerMethod method, HttpServletRequest httpServletRequest) {
        if(usuarioLogado.isLogado()) {
            resultado.include("usuarioLogado",usuarioLogado);
        }

        if(usuarioLogado.isAdministrador()){
            resultado.include("isAdministrador", true);
            resultado.include("isRevisor",true);
        }

        else if(usuarioLogado.isRevisor()){
            resultado.include("isRevisor",true);
        }

        acesso(method);
        stack.next();
    }

    /**
     * Verifica as permissões através da anotação @Seguranca
     * @param method
     * @return
     */
    public boolean acesso(ControllerMethod method){
        Seguranca anotacaoMethod = method.getMethod().getAnnotation(Seguranca.class);
        Seguranca anotacaoClasse = method.getController().getType().getAnnotation(Seguranca.class);
        if(possuiAnotacao(anotacaoMethod,anotacaoClasse)) {
            if(atribuirPermissoes(anotacaoMethod,anotacaoClasse)){
              return true;
            } else {
                resultado.use(Results.http()).sendError(403, "Usuário não autorizado");
            }
        }
        return true;
    }

    public boolean verificarAnotacoes(Seguranca anotacao) {
        if (anotacao.perfil().equals(Perfil.ADMIN)) {
            if(usuarioLogado.isAdministrador()){
                return true;
            } else {
                return false;
            }
        }
        else if(anotacao.perfil().equals(Perfil.REVISOR)) {
            if(usuarioLogado.isRevisor()){
                return true;
            } else {
                return false;
            }
        } else if (anotacao.perfil().equals(Perfil.PADRAO)) {
            if(usuarioLogado.isPadrao()){
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean acessoMethod(Seguranca anotacao){
        boolean permitido = verificarAnotacoes(anotacao);
        return permitido;
    }

    public boolean possuiAnotacao(Seguranca anotacaoMethod, Seguranca anotacaoClasse) {
        return (anotacaoMethod != null || anotacaoClasse != null);
    }

    public boolean atribuirPermissoes(Seguranca anotacaoMethod, Seguranca anotacaoClasse) {
        if(anotacaoClasse != null) {
            if(anotacaoMethod != null) {
                return acessoMethod(anotacaoMethod);
            }
            return acessoMethod(anotacaoClasse);
        }

        return acessoMethod(anotacaoMethod);
    }
}
