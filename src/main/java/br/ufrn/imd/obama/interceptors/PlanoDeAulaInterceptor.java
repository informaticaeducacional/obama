package br.ufrn.imd.obama.interceptors;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import com.google.common.base.Strings;

import br.com.caelum.vraptor.Accepts;
import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.interceptor.SimpleInterceptorStack;
import br.com.caelum.vraptor.view.Results;
import br.ufrn.imd.obama.anotacoes.PlanoDeAulaSeguranca;
import br.ufrn.imd.obama.dao.PlanoDeAulaDao;
import br.ufrn.imd.obama.dominio.PlanoDeAula;
import br.ufrn.imd.obama.dominio.StatusSubmissao;
import br.ufrn.imd.obama.dominio.UsuarioLogado;

@Intercepts(after = SegurancaInterceptor.class)
public class PlanoDeAulaInterceptor {
    private Result resultado;
    private UsuarioLogado usuarioLogado;
    private PlanoDeAulaDao planoDeAulaDao;

    @Inject
    public PlanoDeAulaInterceptor(Result resultado, UsuarioLogado usuarioLogado, PlanoDeAulaDao planoDeAulaDao) {
        this.resultado = resultado;
        this.usuarioLogado = usuarioLogado;
        this.planoDeAulaDao = planoDeAulaDao;
    }

    @Deprecated
    PlanoDeAulaInterceptor() {
    }

    /**
     * Primeira função chamada no intercepts. Ela verifica se a lógica do interceptador deve ser executada de acordo com
     * a classe ou com o método.
     *
     * @param method
     * @return
     */
    @Accepts
    public boolean verificarSegurança(ControllerMethod method) {
        return method.containsAnnotation(PlanoDeAulaSeguranca.class);
    }

    @AroundCall
    public void autoriza(SimpleInterceptorStack stack, ControllerMethod method, ServletContext context, HttpServletRequest httpServletRequest) {
        String idPlano = httpServletRequest.getParameter("id");
        PlanoDeAula planoDeAula = Strings.isNullOrEmpty(idPlano)? null : planoDeAulaDao.buscarPlanoPorId(Integer.parseInt(idPlano));
        if(planoDeAula == null) {
        	resultado.use(Results.http()).sendError(404, "Página nã encontrada");
        } else if (verificarAcesso(method, planoDeAula)) {
            stack.next();
        } else {
        	
        }
    }

    private boolean verificarAcesso(ControllerMethod method, PlanoDeAula plano) {
    	if(usuarioLogado.isAdministrador()) {
    		return true;
    	}
        if (method.containsAnnotation(PlanoDeAulaSeguranca.class)) {
        	boolean permitirAcesso = false;
            if(plano.getStatus() == StatusSubmissao.VALIDADO.getId()) {
            	permitirAcesso = true;
            } else if(usuarioLogado.isLogado()) {
            	plano = planoDeAulaDao.buscarPlanoPorUsuarioeToken(usuarioLogado.getUsuario(), plano.getToken());
            	permitirAcesso = plano!= null ? true : false;
            	if(!permitirAcesso) {
            		resultado.use(Results.http()).sendError(403, "Usuário não autorizado");
            	}
            } else {
            	resultado.use(Results.http()).sendError(403, "Usuário não autorizado");
                permitirAcesso = false;
            }
            return permitirAcesso;
        }
        return true;
    }

}
