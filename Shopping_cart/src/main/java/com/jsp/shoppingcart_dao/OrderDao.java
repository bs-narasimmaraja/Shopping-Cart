package com.jsp.shoppingcart_dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.shoppingcart_dto.Item;
import com.jsp.shoppingcart_dto.Orders;

@Repository
public class OrderDao {
	@Autowired
	EntityManagerFactory emf;
	
	public void  saveOrders(Orders o) {
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.persist(o);
		et.commit();
		
}
	public void updateOrders(Orders o){
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.persist(o);
		et.commit();
	}
	
	public void DeleteOrdersById(Orders id) {
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		Orders o=em.find(Orders.class, id);
		et.begin();
		em.persist(o);
		et.commit();
	}
	public Orders FindItemById(int id) {
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		Orders o=em.find(Orders.class, id);
		if(o!=null)return o;
		else return null;
		
		
		
		
		
		
		
		
		
	}

}
