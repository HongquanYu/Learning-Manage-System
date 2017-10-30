package com.umd.ezcomm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.umd.ezcomm.model.dao.impl.UserServiceImpl;

/** @author: Hongquan Yu
 *  @date: Oct 11, 2017
 *
 *  @From: University of Maryland, College Park
 *  @Email: hyu12346@terpmail.umd.edu
 */
public class HomePageController {

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPage(HttpServletRequest request, HttpServletResponse response) {
		String nn = request.getParameter("txtUserName");
		String pp = request.getParameter("txtPassd");
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserServiceImpl test = (UserServiceImpl) context.getBean("UserServiceImpl");

	    if (test.userAuth(nn, pp))
	    		return "home";
		return "error";
	}
	
}
