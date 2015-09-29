package br.com.caelum.vraptor.interceptor;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.annotation.Log;
import br.com.caelum.vraptor.interceptor.SimpleInterceptorStack;

@AcceptsWithAnnotations(Log.class)
@Intercepts(after = { 
		AutorizadorInterceptor.class,
		LogInterceptor.class
})
public class ControleDeTransacaoInterceptor {

	private EntityManager em;

	@Inject
	public ControleDeTransacaoInterceptor(EntityManager em) {
		this.em = em;
	}

	ControleDeTransacaoInterceptor() {
		this(null);
	}

	@AroundCall
	public void intercepta(SimpleInterceptorStack stack) {
		em.getTransaction().begin();
		stack.next();
		em.getTransaction().commit();
	}

}
