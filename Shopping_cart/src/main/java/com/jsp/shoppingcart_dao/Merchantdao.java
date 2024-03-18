package com.jsp.shoppingcart_dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.swing.border.EtchedBorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.shoppingcart_dto.Merchant;
import com.jsp.shoppingcart_dto.Product;
@Repository
public class Merchantdao {
	@Autowired
	EntityManagerFactory emf;
	
	@Autowired
	ProductDao pdao;
	
	public void SaveMerchant(Merchant m) {
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.persist(m);
		
		
		et.commit();
	}
	public Merchant login(String email ,String password) {
		EntityManager em=emf.createEntityManager();
		Query query =em.createQuery("select m from Merchant m where m.email=?1 and m.password=?2");
		query.setParameter(1, email);
		query.setParameter(2, password);
		try {
			Merchant merchant =(Merchant)query.getSingleResult();
			return merchant;
		}catch(NoResultException e) {
			return null;
		}
	}
	public void updateMerchant(Merchant m) {
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.merge(m);
		et.commit();
	}
	public void DeleteMerchantById(int id) {
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		Merchant m=em.find(Merchant.class, id);
		et.begin();
		em.persist(m);
		et.commit();
	}
	public Merchant findMerchantById(int id) {
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		Merchant m=em.find(Merchant.class, id);
		if(m!=null)return m;
		else return null;
	}
	public Merchant deleteProductFromMerchant(int merchant_id,int product_id) {
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Merchant merchant=em.find(Merchant.class, merchant_id);
		List<Product> products=merchant.getProducts();
		//products.stream().filter(product->product.getId()!=product_id).collect(Collectors.toList());
		List<Product> productsList =new ArrayList<>();
		for(Product p:products) {
			if(p.getId() !=product_id)
				productsList.add(p);
			
		}
		merchant.setProducts(productsList);
		
		return merchant;
	
	
	}
			
		
		
		
	}
	

