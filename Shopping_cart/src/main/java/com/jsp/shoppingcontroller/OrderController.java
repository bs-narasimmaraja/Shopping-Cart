package com.jsp.shoppingcontroller;

import java.util.ArrayList;
import java.util.List;

import javax.naming.directory.SchemaViolationException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.shoppingcart_dao.Cartdao;
import com.jsp.shoppingcart_dao.Customerdao;
import com.jsp.shoppingcart_dao.OrderDao;
import com.jsp.shoppingcart_dao.ProductDao;
import com.jsp.shoppingcart_dto.Cart;
import com.jsp.shoppingcart_dto.Customer;
import com.jsp.shoppingcart_dto.Item;
import com.jsp.shoppingcart_dto.Orders;
import com.jsp.shoppingcart_dto.Product;
@Controller
public class OrderController {
	@Autowired
	OrderDao dao;
	@Autowired
	Customerdao cdao;

	@Autowired
	ProductDao pdao;
	
	@Autowired
	Cartdao cartdao;
	
	@RequestMapping("/addorder")
	public ModelAndView addorder() {
		Orders o=new Orders();
		ModelAndView mav=new ModelAndView();
		mav.addObject("ordersobj",o);
		mav.setViewName("ordersform");
		return mav;
	}
	@RequestMapping("/saveorder")
	public ModelAndView saveOrder(@ModelAttribute("ordersobj")Orders o,HttpSession session) {
		Customer c=(Customer)session.getAttribute("customerinfo");
		Customer customer=cdao.findCustomerById(c.getId());
		Cart cart=customer.getCart();
		List<Item> items=cart.getItems();
		
		
		List<Item> itemlist=new ArrayList<>();
		
		List<Item> itemswithgreaterquantity= new ArrayList<>();
		
		for(Item i:items) {
			Product p=pdao.findProductById(i.getP_id());
			if(i.getQuantity()<p.getStock()) {
				itemlist.add(i);
				p.setStock(p.getStock()-i.getQuantity());
				
				pdao.updateProduct(p);
				
			}
			else {
				itemswithgreaterquantity.add(i);
			}
			
		}
		o.setItems(itemlist);
		double totalpriceoforder =0;
		for(Item i:itemlist) {
			totalpriceoforder+=i.getPrice();
		}
		cart.setItems(itemswithgreaterquantity);
		
		double totalprice=0;
		for(Item i:itemswithgreaterquantity) {
			totalprice+=i.getPrice();
			
		}
		List<Orders> orders=customer.getOrders();
		if(orders.size()>0) {
			orders.add(o);
			customer.setOrders(orders);
	}
		else {
			List<Orders> orders1=new ArrayList<>();
			orders1.add(o);
			customer.setOrders(orders1);
		}
		
		customer.setCart(cart);
		cartdao.updatecart(cart);
		dao.saveOrders(o);
		cdao.updateCustomer(customer);
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("msg", "order placed successfully");
		mav.addObject("orderdetails", o);
		mav.setViewName("CustomerBill");
		return mav;
	
		
	}
	
	
	
	
	
}
