package com.umd.ezcomm.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

	private static final Logger log = LogManager.getLogger();

	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	UserServiceImpl userService = (UserServiceImpl) context.getBean("UserServiceImpl");
	CourseServiceImpl courseService = (CourseServiceImpl) context.getBean("CourseServiceImpl");
	StudentServiceImpl studentService = (StudentServiceImpl) context.getBean("StudentServiceImpl");

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String portal(HttpServletRequest request, HttpServletResponse response) {
		return "login";
	}

	@RequestMapping(value = "/studentHome", method = RequestMethod.GET)
	public String studentHomepage(HttpServletRequest request, HttpSession session, Map<String, Object> model) {

		String ue = (String) session.getAttribute("userEmail");
		String userID = userService.getUID(ue);

		List<Course> courses = null;
		List<Message> messages = null;
		List<Assignment> assignments = null;

		try {
			courses = userService.courseEnrolled(userID);
			messages = userService.messageReceived(userID);
			assignments = studentService.getAssignments(userID);
		} catch (Exception e) {
			log.info("data access error.");
			model.put("dataException", true);
		}

		model.put("userID", userID);
		model.put("courseNum", courses == null ? 0 : courses.size());
		model.put("messageNum", messages == null ? 0 : messages.size());
		model.put("assignmentNum", assignments == null ? 0 : assignments.size());

		model.put("userCourses", courses);
		model.put("userMessages", messages);
		model.put("userAssignemnts", assignments);

		return "studentHome";
	}
	
	
	@RequestMapping(value = "/instructorHome", method = RequestMethod.GET)
	public String instructorHomepage(HttpServletRequest request, HttpSession session, Map<String, Object> model) {

		String ue = (String) session.getAttribute("userEmail");
		String userID = userService.getUID(ue);

		List<Course> courses = null;
		List<Message> messages = null;
		List<Assignment> assignments = null;

		try {
			courses = userService.courseEnrolled(userID);
			messages = userService.messageReceived(userID);
			assignments = studentService.getAssignments(userID);
		} catch (Exception e) {
			log.info("data access error.");
			model.put("dataException", true);
		}

		model.put("userID", userID);
		model.put("courseNum", courses == null ? 0 : courses.size());
		model.put("messageNum", messages == null ? 0 : messages.size());
		model.put("assignmentNum", assignments == null ? 0 : assignments.size());

		model.put("userCourses", courses);
		model.put("userMessages", messages);
		model.put("userAssignemnts", assignments);

		return "instructorHome";
	}

	/* user authentication and load data. */

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String userLogin(HttpServletRequest request, HttpSession session, Map<String, Object> model) {
		String ue = request.getParameter("userEmail");
		String up = request.getParameter("userPasd");
		String userID = userService.getUID(ue);
		
		boolean isStudent = userService.isStudent(userID);
		boolean isLegalUser = userService.userAuth(ue, up);
		
		if (!isLegalUser) {
			model.put("illegalUser", true);
			return "login";
		} else {
			session.setAttribute("userEmail", ue);
			session.setAttribute("isLegalUser", true);
			return isStudent ? "redirect:/studentHome.html" : "redirect:/instructorHome.html";
		}
	}

	@RequestMapping(value = "/instructorTabs", method = RequestMethod.GET)
	public String goToInstructorTabs(HttpServletRequest request, HttpServletResponse response) {
		return "instructorTabs";
	}
	
	@RequestMapping(value = "/studentTabs", method = RequestMethod.GET)
	public String goToStudentTabs(HttpServletRequest request, HttpServletResponse response) {
		return "studentTabs";
	}

	@RequestMapping(value = "/courseDetail", method = RequestMethod.GET)
	public String goToCourse(HttpServletRequest request, HttpServletResponse response) {
		return "courseDetail";
	}

	@RequestMapping(value = "/assignmentInfo", method = RequestMethod.GET)
	public String goToAssignment(HttpServletRequest request, HttpServletResponse response) {
		return "assignmentDetail";
	}

	@RequestMapping(value = "/courseAssignment", method = RequestMethod.GET)
	public String goToCourseAssignment(HttpServletRequest request, HttpServletResponse response) {
		return "courseAssignment";
	}
	
	@RequestMapping(value = "/gradeProfessor", method = RequestMethod.GET)
	public String goToInstructorGradePage(HttpServletRequest request, HttpServletResponse response) {
		return "gradeProfessor";
	}
	
	@RequestMapping(value = "/courseGrade", method = RequestMethod.GET)
	public String goToCourseGrade(HttpServletRequest request, HttpServletResponse response) {
		return "courseGrade";
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

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		session.invalidate();
		return "login";
	}

	@RequestMapping(value = "/resetPWD", method = RequestMethod.GET)
	public String resetPassword(HttpServletRequest request, HttpServletResponse response) {
		return "passwordReset";
	}
}
