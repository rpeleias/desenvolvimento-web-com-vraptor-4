package br.com.caelum.vraptor.interceptor;

import javax.inject.Inject;

import br.com.caelum.vraptor.Accepts;
import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.annotation.Public;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.controller.LoginController;
import br.com.caelum.vraptor.model.UsuarioLogado;

@Intercepts
public class AutorizadorInterceptor {

    private final Result result;
    private final UsuarioLogado usuarioLogado;
	private final ControllerMethod method;

    @Inject
    public AutorizadorInterceptor(Result result, 
            UsuarioLogado usuarioLogado, 
            ControllerMethod method) {
        this.result = result;
        this.usuarioLogado = usuarioLogado;
		this.method = method;
    }

    protected AutorizadorInterceptor() {
        this(null, null, null);
    }
    
    @Accepts
    public boolean accepts() {
        return !method.containsAnnotation(Public.class);
    }


    @AroundCall
    public void intercept(SimpleInterceptorStack stack) {

        if (usuarioLogado.getUsuario() == null) {
            result.redirectTo(LoginController.class).formulario();
            return;
        }
        stack.next();
    }
}