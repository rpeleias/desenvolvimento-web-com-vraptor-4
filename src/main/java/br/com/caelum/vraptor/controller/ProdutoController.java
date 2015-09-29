package br.com.caelum.vraptor.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.dao.ProdutoDao;
import br.com.caelum.vraptor.model.Produto;
import br.com.caelum.vraptor.view.Results;

@Controller
public class ProdutoController {
	
	private Result result;
	private ProdutoDao dao;
	
	@Deprecated
	ProdutoController() {	
	}

	@Inject
	public ProdutoController(Result result, ProdutoDao dao) {
		this.result = result;
		this.dao = dao;
	}

	@Path("/")
	public void index() {
	}

	@Get
	public void lista() {		
		result.include("produtoList", dao.lista());
	}
	
	@Get
	public void listaEmXml() {
		result.use(Results.xml()).from(dao.lista()).serialize();
	}
	
	@Get
	public void listaEmJson() {
		result.use(Results.json()).from(dao.lista()).serialize();
	}
	
	@Path("/produto/formulario")
	public void formulario() {		
	}
	
	@Post
	public void adiciona(Produto produto) {
		dao.adiciona(produto);
		result.include("mensagem", "Produto adicionado com sucesso");
		result.redirectTo(this).lista();
	}
	
	@Delete
	public void remove(Produto produto) {
		dao.remove(produto);
		result.include("mensagem", "Produto removido com sucesso");
		result.redirectTo(this).lista();
	}
}
