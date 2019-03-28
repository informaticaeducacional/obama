package br.ufrn.imd.obama.interceptors;

import br.com.caelum.vraptor.Accepts;
import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.interceptor.SimpleInterceptorStack;
import br.ufrn.imd.obama.anotacoes.Transacional;

import javax.inject.Inject;
import javax.persistence.EntityManager;

@Intercepts
public class TransacoesInterceptor {
    private EntityManager manager;

    @Inject
    public TransacoesInterceptor(EntityManager manager) {
        this.manager = manager;
    }

    @Deprecated
    TransacoesInterceptor() {
    }

    @AroundCall
    public void trataTransacao(SimpleInterceptorStack stack) {
        try {
            manager.getTransaction().begin();
            stack.next();
            manager.getTransaction().commit();
        } finally {
            if (manager.getTransaction().isActive()) {
                manager.getTransaction().rollback();
            }
        }
    }

    @Accepts
    public boolean accepts(ControllerMethod method){
        return method.containsAnnotation(Transacional.class);
    }

}
