package com.umd.ezcomm.controller;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.umd.ezcomm.model.dao.service.impl.CourseServiceImpl;
import com.umd.ezcomm.model.dao.service.impl.StudentServiceImpl;
import com.umd.ezcomm.model.dao.service.impl.UserServiceImpl;
import com.umd.ezcomm.model.domain.Assignment;
import com.umd.ezcomm.model.domain.Course;
import com.umd.ezcomm.model.domain.Message;

/**
 * @author: Hongquan Yu
 * @date: Oct 11, 2017
 *
 * @From: University of Maryland, College Park
 * @Email: hyu12346@terpmail.umd.edu
 */

@Controller
public class ServiceRequestController {

	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	UserServiceImpl userService = (UserServiceImpl) context.getBean("UserServiceImpl");
	CourseServiceImpl courseService = (CourseServiceImpl) context.getBean("CourseServiceImpl");
	StudentServiceImpl studentService = (StudentServiceImpl) context.getBean("StudentServiceImpl");

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest request, HttpServletResponse response) {
		return "login";
	}

	/* The LoginController user do the user authentication. */

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPage(HttpServletRequest request, Map<String, Object> model) {
		String ue = request.getParameter("userEmail");
		String up = request.getParameter("userPasd");

		boolean isValid = userService.userAuth(ue, up);
		
		if (isValid) {
//			/* TODO:
//			 * 1, get course number, courseID, courseName
//			 * 2, get message number, messageID, message content
//			 * 3, get assignment number, assignmentID, assignment date */
//			
//			String userID = userService.getUID(ue);
//			
//			int courseNum = userService.getCourseNumber(userID);				// YES
//			int messageNum = userService.getMessageNumber(userID);			// 
//			int assignmentNum = studentService.getAssignmentNum(userID);		// YES
//			
//			List<Course> courses;
//			
//			try {
//				courses = userService.courseEnrolled(userID);
//			} catch (Exception e) {
//				
//			}
//			
//			List<Message> messages;
//			
//			try {
//				messages = userService.messageReceived(userID);
//			} catch (Exception e) {
//				
//			}
//			
//			List<Assignment> assignemnts;
//			
//			try {
//				assignemnts = studentService.getAssignments(userID);
//			} catch (Exception e) {
//				
//			}
//			
//			model.put("userID", userID);					// userID
//			
//			model.put("courseNum", courseNum);			// course number
//			model.put("messageNum", messageNum);			// message number
//			model.put("assignmentNum", assignmentNum);	// assignment number
//			
//			model.put("userCourses", courses);			// course list: id, name
//			model.put("userMessages", messages);			// message list: id, content
//			model.put("userAssignemnts", assignemnts);	// assignment list: id, date
		}

		return isValid ? "home" : "error";
	}


	@RequestMapping(value = "/courseInfo", method = RequestMethod.GET)
	public String goToCourse(HttpServletRequest request, HttpServletResponse response) {
		return "courseDetail";
	}

	@RequestMapping(value = "/assignmentInfo", method = RequestMethod.GET)
	public String goToAssignment(HttpServletRequest request, HttpServletResponse response) {
		return "assignmentDetail";
	}

	@RequestMapping(value = "/messages", method = RequestMethod.GET)
	public String goToMessage(HttpServletRequest request, HttpServletResponse response) {
		return "message";
	}

	@RequestMapping(value = "/grades", method = RequestMethod.GET)
	public String goToGrade(HttpServletRequest request, HttpServletResponse response) {
		return "grade";
	}

	@RequestMapping(value = "/profiles", method = RequestMethod.GET)
	public String goToProfile(HttpServletRequest request, HttpServletResponse response) {
		return "profile";
	}

	@RequestMapping(value = "/resetPWD", method = RequestMethod.GET)
	public String resetPassword(HttpServletRequest request, HttpServletResponse response) {
		return "passwordReset";
	}
}
