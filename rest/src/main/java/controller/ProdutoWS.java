package controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import DAO.ProdutoDAO;
import exception.InvalidModelException;
import model.Produto;
import service.Service;

@Path("/produto")
public class ProdutoWS {	
	
	private Service<ProdutoDAO, Produto> service;

	@Path("/create")
	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void create(Produto entity) throws InvalidModelException {
		service.getDao(entity).persist(entity);
	}

	
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/find/{id}")
	public Produto find(@PathParam("id") Integer id) {
		return service.getDao().findById(id);
	}

	
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/findAll")
	public List<Produto> findAll() {
		return service.getDao().findAll(0, 0);
	}

	
	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/update")
	public void update(Produto entity) throws InvalidModelException {
		service.getDao(entity).update(entity);
	}

	
	@DELETE
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/delete")
	public void delete(Produto entity) {
		service.getDao().remove(entity);
	}

}
