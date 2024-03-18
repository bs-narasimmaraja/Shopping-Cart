package com.jsp.shoppingcontroller;

import javax.naming.directory.SchemaViolationException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.shoppingcart_dao.Customerdao;
import com.jsp.shoppingcart_dto.Customer;

@Controller
public class CustomerController {
	@Autowired
	Customerdao cdao;
	
	@RequestMapping("/addcustomer")
	public ModelAndView addcustomer() {
		Customer c=new Customer();
		ModelAndView mav=new ModelAndView();
		mav.addObject("customerobj", c);
		mav.setViewName("customerform");
		return mav;
	}
	@RequestMapping("/savecustomer")
	public ModelAndView savecustomer(@ModelAttribute("customerobj")Customer c,HttpSession session){
		
		cdao.saveCustomer(c);
		ModelAndView mav=new ModelAndView();
		mav.addObject("msg","Register successfully");
		mav.setViewName("customerloginform");
		return mav;
}
	@RequestMapping("/customerloginvalidation")
	public ModelAndView loginvalidation(ServletRequest req,HttpSession session) {
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		Customer c=cdao.login(email, password);
		if(c!=null) {
			ModelAndView mav=new ModelAndView();
			mav.addObject("msg","login successfully");
			mav.setViewName("customeroptions");
			session.setAttribute("customerinfo", c);
			return mav;
	}
		else {
			ModelAndView mav=new ModelAndView();
			mav.addObject("msg","invalid credientials");
			mav.setViewName("customerloginform");
			return mav;
		
		}
}
	
	
	
	
	
}
