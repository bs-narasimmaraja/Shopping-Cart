package com.jsp.shoppingcontroller;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.shoppingcart_dao.Merchantdao;
import com.jsp.shoppingcart_dto.Merchant;
@Controller
public class MerchantController {
	
	@Autowired
	Merchantdao dao;
	
	@RequestMapping("/addmerchant")
	public ModelAndView addmerchant() {
		Merchant m=new Merchant();
		ModelAndView mav=new ModelAndView();
		mav.addObject("merchantobj", m);
		mav.setViewName("merchantform");
		return mav;
	}
	@RequestMapping("/savemerchant")
	public ModelAndView saveMerchant(@ModelAttribute("merchantobj")Merchant m) {
		dao.SaveMerchant(m);
		ModelAndView mav=new ModelAndView();
		mav.addObject("msg","data saved succesfully");
		mav.setViewName("menu");
		return mav;
	}
	@RequestMapping("/loginvalidation")
	public ModelAndView loginValidation(ServletRequest request ,HttpSession session) {
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		Merchant m=dao.login(email, password);
		ModelAndView mav=new ModelAndView();
		
		if(m!=null) {
			mav.addObject("msg","data saved successfully");
			mav.setViewName("merchantoption");
			session.setAttribute("merchantinfo", m);
			return mav;
			}
		else {
			mav.addObject("msg","Invalid credientials");
			mav.setViewName("merchantloginform");
			return mav;
			}
}
	
	
	

}
