package com.sakshi.restws;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.sakshi.restws.entities.Number;

@Consumes("application/json")
@Produces("application/json")
@Path("/productservice")
public interface ProductService {
	
	@Path("/products")
	@GET
	List<Number> getProducts();
	
	@Path("/products/{id}")
	@GET
	Number getProduct(@PathParam("id") int id);
	
	@Path("/products")
	@POST
	Response createProduct(Number product);
	
	/*@Path("/products")
	@PUT
	Response updateProduct(Number product);*/
	
	@Path("/products/{id}")
	@DELETE
	Response deleteProduct(@PathParam("id")  int id);
	
	@Path("/products")
	@PUT
	Response updateCountServ();
	

}
