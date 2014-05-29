package br.com.caelum.vraptor.controller;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.dao.ProdutoDao;
import br.com.caelum.vraptor.model.Produto;
import br.com.caelum.vraptor.util.JPAUtil;

@Controller
public class ProdutoController {
	
	@Path("/")
    public void inicio() {
    }
	
    @Path("/produto/lista")
    public List<Produto> lista() {
        EntityManager em = JPAUtil.criaEntityManager();
        ProdutoDao dao = new ProdutoDao(em);
        return dao.lista();
    }

    @Path("/produto/formulario")
    public void formulario(){
    }
    
    @Path("/produto/adiciona")
    public void adiciona(Produto produto) {
        EntityManager em = JPAUtil.criaEntityManager();
        em.getTransaction().begin();
        ProdutoDao dao = new ProdutoDao(em);
        dao.adiciona(produto);
        em.getTransaction().commit();
    }
}
