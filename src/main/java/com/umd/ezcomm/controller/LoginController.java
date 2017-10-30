package com.umd.ezcomm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.umd.ezcomm.model.dao.impl.UserServiceImpl;

/** @author: Hongquan Yu
 *  @date: Oct 9, 2017
 *
 *  @From: University of Maryland
 *  @Email: hyu12346@terpmail.umd.edu
 */

@Controller
public class LoginController {
	
	/* The LoginController user do the user authentication. */

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPage(HttpServletRequest request, HttpServletResponse response) {
		String nn = request.getParameter("txtUserName");
		String pp = request.getParameter("txtPassd");
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserServiceImpl test = (UserServiceImpl) context.getBean("UserServiceImpl");
		boolean isValid = test.userAuth(nn, pp);
		
		// valid user, we need to retrieve value for presenting in webpage
		if (isValid) {
			
		}
		
		return isValid ? "home" : "error";
	}
}
