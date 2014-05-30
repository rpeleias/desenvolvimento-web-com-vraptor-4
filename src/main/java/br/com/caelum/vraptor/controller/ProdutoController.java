package br.com.caelum.vraptor.controller;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.dao.ProdutoDao;
import br.com.caelum.vraptor.model.Produto;
import br.com.caelum.vraptor.util.JPAUtil;
import br.com.caelum.vraptor.view.Results;

@Controller
public class ProdutoController {
	
	private final Result result;

	@Inject
	public ProdutoController(Result result) {
	    this.result = result;
	}
	
	protected ProdutoController() {
		this(null);
	}
	
	@Path("/")
    public void inicio() {
    }
	
	@Get
	public void lista() {
	    EntityManager em = JPAUtil.criaEntityManager();
	    ProdutoDao dao = new ProdutoDao(em);
	    result.include("produtoList", dao.lista());
	}
	
	@Get
	public void listaEmXml() {
	    EntityManager em = JPAUtil.criaEntityManager();
	    ProdutoDao dao = new ProdutoDao(em);
	    result.use(Results.xml()).from(dao.lista()).exclude("quantidade").serialize();
	}
	
	@Get
	public void listaEmJson() {
	    EntityManager em = JPAUtil.criaEntityManager();
	    ProdutoDao dao = new ProdutoDao(em);
	    result.use(Results.json()).from(dao.lista()).serialize();
	}

    @Get
    public void formulario(){
    }
    
    @Post
    public void adiciona(Produto produto) {
        EntityManager em = JPAUtil.criaEntityManager();
        em.getTransaction().begin();
        ProdutoDao dao = new ProdutoDao(em);
        dao.adiciona(produto);
        em.getTransaction().commit();
        result.include("mensagem", "Produto adicionado com sucesso!");
        result.redirectTo(this).lista();
    }
}
