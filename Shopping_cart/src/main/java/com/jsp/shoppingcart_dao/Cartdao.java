package com.jsp.shoppingcart_dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.shoppingcart_dto.Cart;

@Repository
public class Cartdao {
	@Autowired
	EntityManagerFactory emf;
	
	public void savecart(Cart c) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(c);
		et.commit();
	}
	public void updatecart(Cart c) {
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.merge(c);
		et.commit();

	}
	public void deletecartBYId(int id) {
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		Cart c=em.find(Cart.class, id);
		et.begin();
		em.persist(c);
		et.commit();

	}
	public Cart findCartById(int id) {
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		Cart c=em.find(Cart.class, id);
		if(c!=null)return c;
		else return null;
	}
	public void removeItemFromCart(int cart_id,int item_id) {
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
	}
	public Cart removeAllItemsFromCart(int id) {
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		Cart c=em.find(Cart.class, id);
		c.setItems(null);
		c.setTotalprice(0);
		et.begin();
		em.merge(c);
		et.commit();
		return c;

	}
}
