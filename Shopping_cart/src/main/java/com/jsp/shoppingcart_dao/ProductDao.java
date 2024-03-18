package com.jsp.shoppingcart_dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.shoppingcart_dto.Customer;
import com.jsp.shoppingcart_dto.Product;
@Repository
public class ProductDao {

	@Autowired
	EntityManagerFactory emf;
	
	public void  saveProduct(Product p) {
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.persist(p);
		et.commit();
		
}
	public void updateProduct(Product p){
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.merge(p);
		et.commit();
	}
	
	public void DeleteProductById(int id) {
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		Product p=em.find(Product.class, id);
		et.begin();
		em.persist(p);
		et.commit();
	}
	public Product findProductById(int id) {
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		Product p=em.find(Product.class, id);
		if(p!=null)return p;
		else return null;
	}
	public List<Product> FindAllProducts(){
		EntityManager em=emf.createEntityManager();
		Query query =em.createQuery("select c from Product c");
		return query.getResultList();
				
		
	}
	public List<Product> findProductByBrand(String brand){
		EntityManager em=emf.createEntityManager();
		Query query=em.createQuery("select p from Product p where p.brand=?1");
		query.setParameter(1,brand);
		return query.getResultList();
	
		
	}


}
