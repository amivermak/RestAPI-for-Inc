package com.sakshi.restws;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.sakshi.restws.entities.Number;
import com.sakshi.restws.repos.ProductRepository;

public class ProductServiceImpl implements ProductService {
	
	
	
	@Autowired
	ProductRepository repository;

	@Override
	public List<Number> getProducts() {
		return repository.findAll();
	}

	@Override
	public Number getProduct(int id) {
		return repository.findById(id).get();
	}

	@Override
	public Response createProduct(Number product) {
		Number savedProd= repository.save(product);
		return Response.ok(savedProd).build();
	}

	/*@Override
	public Response updateProduct(Number product) {
		Number savedProd= repository.save(product);
		return Response.ok(savedProd).build();
	}*/

	@Override
	public Response deleteProduct(int id) {
		 repository.deleteById(id);
		 return Response.ok().build();
	}

	@Override
	public Response updateCountServ() {
		repository.updateCount();
		// TODO Auto-generated method stub
		return Response.ok().build();
	}

/*	@Override
	public Response updateCount(Product product) {
		EntityManagerFactory entityManagerFactory =
		          Persistence.createEntityManagerFactory("Product");
		System.out.println("-- updating count --");
	      EntityManager em = entityManagerFactory.createEntityManager();
	      em.getTransaction().begin();
	      Query query = em.createQuery("UPDATE product e SET e.id = e.id + 1 ");
	      int rowsUpdated = query.executeUpdate();
	      System.out.println("entities Updated: " + rowsUpdated);
	      em.getTransaction().commit();
	      em.close();
	      return Response.ok().build();
	}*/

}
