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

import exception.InvalidModelException;
import model.Venda;
import service.VendaService;


@Path("/venda")
public class VendaWS {
	VendaService service = new VendaService();

	@Path("/create")
	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void create(Venda entity) {
		service.persist(entity);
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/find/{id}")
	public Venda find(@PathParam("id") Integer id) {
		return service.findById(id.longValue());
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/findAll")
	public List<Venda> findAll() {
		return service.findAll(0, 0);
	}

	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/update")
	public void update(Venda entity) throws InvalidModelException {
		service.update(entity);
	}

	@DELETE
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/delete")
	public void delete(Venda entity) {
		service.remove(entity);
	}

}
