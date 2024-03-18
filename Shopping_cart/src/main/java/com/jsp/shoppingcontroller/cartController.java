package com.jsp.shoppingcontroller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.shoppingcart_dao.Customerdao;
import com.jsp.shoppingcart_dto.Cart;
import com.jsp.shoppingcart_dto.Customer;
import com.jsp.shoppingcart_dto.Item;
@Controller
public class cartController {

	@Autowired
	cartController cdao;
	
	@Autowired
	Customerdao custdao;
	
	@RequestMapping("/fetchitemfromcart")
	public ModelAndView fetchitemfromcart(HttpSession session) {
		Customer c=(Customer)session.getAttribute("customerinfo");
		
		Customer customer=custdao.findCustomerById(c.getId());
		Cart cart=customer.getCart();
		List<Item> items=cart.getItems();
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("itemlist",items);
		mav.addObject("totalprice", cart.getTotalprice());
		mav.setViewName("displaycartitemtocustomer");
		
		return mav;
		
		
	}
}
