package com.jsp.shoppingcart_dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.shoppingcart_dto.Item;
@Repository
public class itemDao {
	@Autowired
	EntityManagerFactory emf;
	
	public void  saveItem(Item i) {
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.persist(i);
		et.commit();
		
}
	public void updateItem(Item i){
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.persist(i);
		et.commit();
	}
	
	public void DeleteItemById(Item id) {
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		Item i=em.find(Item.class, id);
		et.begin();
		em.persist(i);
		et.commit();
	}
	public Item FindItemById(int id) {
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		Item i=em.find(Item.class, id);
		if(i!=null)return i;
		else return null;
		
		
		
		
		
		
		
		
		
	}
	
}
