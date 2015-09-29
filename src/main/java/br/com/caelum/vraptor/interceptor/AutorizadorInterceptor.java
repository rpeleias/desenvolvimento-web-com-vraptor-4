package br.com.caelum.vraptor.interceptor;

import javax.inject.Inject;

import br.com.caelum.vraptor.Accepts;
import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.annotation.Public;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.controller.LoginController;
import br.com.caelum.vraptor.sessao.UsuarioLogado;

@Intercepts
public class AutorizadorInterceptor {

	private Result result;
	private UsuarioLogado usuarioLogado;
	private ControllerMethod controllerMethod;
	
	@Deprecated
	AutorizadorInterceptor() {
		this(null, null, null);
	}
	
	@Inject
	public AutorizadorInterceptor(Result result, UsuarioLogado usuarioLogado, ControllerMethod controllerMethod) {
		this.result = result;
		this.usuarioLogado = usuarioLogado;
		this.controllerMethod = controllerMethod;
	}


	@AroundCall
	public void intercepta(SimpleInterceptorStack stack) {
		if (usuarioLogado.getUsuario() == null) {
			result.redirectTo(LoginController.class).formulario();
			return;
		}
		stack.next();
	}
	
	@Accepts
	public boolean accepts() {
		return !controllerMethod.containsAnnotation(Public.class);
	}
}
