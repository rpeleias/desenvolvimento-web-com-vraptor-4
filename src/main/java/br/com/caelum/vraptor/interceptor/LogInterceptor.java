package br.com.caelum.vraptor.interceptor;

import javax.inject.Inject;

import br.com.caelum.vraptor.BeforeCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.annotation.Log;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.interceptor.AcceptsWithAnnotations;

@AcceptsWithAnnotations(Log.class)
@Intercepts
public class LogInterceptor {

	private ControllerMethod controllerMethod;

	@Inject
	public LogInterceptor(ControllerMethod controllerMethod) {
		this.controllerMethod = controllerMethod;
	}
	
	@Deprecated
	LogInterceptor() {
		this(null);
	}
	
	@BeforeCall
	public void before() {
		System.out.println("Executando o método = " + controllerMethod.getMethod().getName());
	}
	
}
