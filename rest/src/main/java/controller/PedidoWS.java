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

import DAO.PedidoDAO;
import exception.InvalidModelException;
import model.Pedido;
import service.Service;


@Path("/venda")
public class PedidoWS {
	private Service<PedidoDAO, Pedido> service = new Service<PedidoDAO, Pedido> (PedidoDAO.class);

	@Path("/create")
	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void create(Pedido entity) throws InvalidModelException {
		service.getDao(entity).persist(entity);
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/find/{id}")
	public Pedido find(@PathParam("id") Integer id) {
		return service.getDao().findById(id);
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/findAll")
	public List<Pedido> findAll() {
		return service.getDao().findAll(0, 0);
	}

	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/update")
	public void update(Pedido entity) throws InvalidModelException {
		service.getDao(entity).update(entity);
	}

	@DELETE
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/delete")
	public void delete(Pedido entity) {
		service.getDao().remove(entity);
	}

}
