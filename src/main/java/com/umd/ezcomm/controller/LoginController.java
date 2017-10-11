package com.umd.ezcomm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.umd.ezcomm.model.dao.impl.DBManagerImpl;

/** @author: Hongquan Yu
 *  @date: Oct 9, 2017
 *
 *  @From: University of Maryland
 *  @Email: hyu12346@terpmail.umd.edu
 */

@Controller
public class LoginController {
	
	/*
	 * The LoginController show login page, and 
	 */

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPage(HttpServletRequest request, HttpServletResponse response) {
		String nn = request.getParameter("txtUserName");
		String pp = request.getParameter("txtPassd");
		
//		System.out.println("Made it to the controller");
//		System.out.println("------user name: " + nn);
//		System.out.println("------user pass: " + pp);
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	    DBManagerImpl test = (DBManagerImpl) context.getBean("DBManagerImpl");
	    
	    if (test.userAuth(nn, pp))
	    		return "home";
		return "error";
	}
}
