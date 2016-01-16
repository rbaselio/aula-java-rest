
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

import DAO.ClienteDAO;
import exception.InvalidModelException;
import model.Cliente;
import service.Service;

@Path("/cliente")
public class ClienteWS {

	private Service<ClienteDAO, Cliente> service = new Service<ClienteDAO, Cliente>(ClienteDAO.class);
	

	@Path("/create")
	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void create(Cliente entity) throws InvalidModelException {
		
		
		service.getDao(entity).persist(entity);
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/find/{id}")
	public Cliente find(@PathParam("id") Integer id) throws InvalidModelException {
		return service.getDao().findById(id);
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/findAll")
	public List<Cliente> findAll() {
		return service.getDao().findAll(0, 0);
	}

	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/update")
	public void update(Cliente entity) throws InvalidModelException {
		service.getDao(entity).update(entity);
	}

	@DELETE
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/delete")
	public void delete(Cliente entity) {
		service.getDao().remove(entity);
	}

}
