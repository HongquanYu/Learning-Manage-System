package com.umd.ezcomm.controller;

import java.util.LinkedList;
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
import com.umd.ezcomm.model.dao.service.impl.InstructorServiceImpl;
import com.umd.ezcomm.model.dao.service.impl.StudentServiceImpl;
import com.umd.ezcomm.model.dao.service.impl.UserServiceImpl;
import com.umd.ezcomm.model.domain.Assignment;
import com.umd.ezcomm.model.domain.Course;
import com.umd.ezcomm.model.domain.Message;
import com.umd.ezcomm.model.domain.Student;

/**
 * @author: Hongquan Yu
 * @date: Oct 11, 2017
 *
 * @From: University of Maryland, College Park
 * @Email: hyu12346@terpmail.umd.edu
 */

@Controller
public class ServiceRequestController {
	
	private final String emailValidateRegEx = "^([0-9a-zA-Z]([-.\\w]*[0-9a-zA-Z])*@([0-9a-zA-Z][-\\w]*[0-9a-zA-Z]\\.)+[a-zA-Z]{2,9})$";

	private static final Logger log = LogManager.getLogger();

	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	UserServiceImpl userService = (UserServiceImpl) context.getBean("UserServiceImpl");
	CourseServiceImpl courseService = (CourseServiceImpl) context.getBean("CourseServiceImpl");
	StudentServiceImpl studentService = (StudentServiceImpl) context.getBean("StudentServiceImpl");
	InstructorServiceImpl instructorService = (InstructorServiceImpl) context.getBean("InstructorServiceImpl");

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String portal(HttpServletRequest request, HttpServletResponse response) {
		return "login";
	}

	@RequestMapping(value = "/stu/studentHome", method = RequestMethod.GET)
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

		model.put("courseNum", courses == null ? 0 : courses.size());
		model.put("messageNum", messages == null ? 0 : messages.size());
		model.put("assignmentNum", assignments == null ? 0 : assignments.size());

		model.put("userCourses", courses);
		model.put("userMessages", messages);
		model.put("userAssignemnts", assignments);

		return "/stu/studentHome";
	}
	
	
	@RequestMapping(value = "/ins/instructorHome", method = RequestMethod.GET)
	public String instructorHomepage(HttpServletRequest request, HttpSession session, Map<String, Object> model) {

		String ue = (String) session.getAttribute("userEmail");
		String userID = userService.getUID(ue);

		List<Course> courses = null;
		List<Message> messages = null;

		try {
			courses = userService.courseEnrolled(userID);
			messages = userService.messageReceived(userID);
		} catch (Exception e) {
			log.info("data access error.");
			model.put("dataException", true);
		}

		model.put("courseNum", courses == null ? 0 : courses.size());
		model.put("messageNum", messages == null ? 0 : messages.size());

		model.put("insCourses", courses);
		model.put("insMessages", messages);

		return "/ins/instructorHome";
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
			session.setAttribute("userID", userID);
			session.setAttribute("userEmail", ue);
			session.setAttribute("isLegalUser", true);
			return isStudent ? "redirect:stu/studentHome.html" : "redirect:ins/instructorHome.html";
		}
	}

	@RequestMapping(value = "/ins/instructorTabs", method = RequestMethod.GET)
	public String goToInstructorTabs(HttpServletRequest request, HttpSession session, 
			HttpServletResponse response, Map<String, Object> model) {
		
		String userID = (String) session.getAttribute("userID");
		List<Course> courseList = instructorService.getCourseList(userID);
		List<Student> studentList = new LinkedList<>();
		
		
		List<Course> courses = null;
		List<Message> messages = null;
		List<Assignment> assignments = null;

//		try {
			courses = userService.courseEnrolled(userID);
//			messages = userService.messageReceived(userID);
//			assignments = studentService.getAssignments(userID);
			for (Course c : courseList) {
				studentList.addAll(instructorService.getStudentList(c.getID()));
			}
			
		System.out.println("----student list size: " + studentList.size());
//			
//		} catch (Exception e) {
//			log.info("data access error.");
//			model.put("dataException", true);
//		}

//		model.put("courseNum", courses == null ? 0 : courses.size());
//		model.put("messageNum", messages == null ? 0 : messages.size());
//		model.put("assignmentNum", assignments == null ? 0 : assignments.size());
		
		model.put("studentList", studentList);
		model.put("userCourses", courses);
		model.put("userMessages", messages);
		model.put("userAssignemnts", assignments);
		
		return "/ins/instructorTabs";
	}
	
	@RequestMapping(value = "/stu/studentTabs", method = RequestMethod.GET)
	public String goToStudentTabs(HttpServletRequest request, HttpSession session, 
			HttpServletResponse response, Map<String, Object> model) {
		String userID = (String) session.getAttribute("userID");
		
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

		model.put("courseNum", courses == null ? 0 : courses.size());
		model.put("messageNum", messages == null ? 0 : messages.size());
		model.put("assignmentNum", assignments == null ? 0 : assignments.size());

		model.put("userCourses", courses);
		model.put("userMessages", messages);
		model.put("userAssignemnts", assignments);
		
		return "/stu/studentTabs";
	}
	
	@RequestMapping(value = "/ins/gradeProfessor", method = RequestMethod.GET)
	public String goToInstructorGradePage(HttpServletRequest request, HttpServletResponse response, 
			HttpSession session, Map<String, Object> model) {
		String userID = (String) session.getAttribute("userID");
		
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

		model.put("courseNum", courses == null ? 0 : courses.size());
		model.put("messageNum", messages == null ? 0 : messages.size());
		model.put("assignmentNum", assignments == null ? 0 : assignments.size());

		model.put("userCourses", courses);
		model.put("userMessages", messages);
		model.put("userAssignemnts", assignments);
		
		return "/ins/gradeProfessor";
	}

	@RequestMapping(value = "/stu/gradeStudent", method = RequestMethod.GET)
	public String goToGrade(HttpServletRequest request, HttpServletResponse response, 
			HttpSession session, Map<String, Object> map) {
		String userID = (String) session.getAttribute("userID");

		List<Course> courses = null;
		List<Message> messages = null;
		List<Assignment> assignments = null;

		try {
			courses = userService.courseEnrolled(userID);
			messages = userService.messageReceived(userID);
			assignments = studentService.getAssignments(userID);
		} catch (Exception e) {
			log.info("data access error.");
			map.put("dataException", true);
		}
		

		map.put("courseNum", courses == null ? 0 : courses.size());
		map.put("messageNum", messages == null ? 0 : messages.size());
		map.put("assignmentNum", assignments == null ? 0 : assignments.size());

		map.put("userCourses", courses);
		map.put("userMessages", messages);
		map.put("userAssignemnts", assignments);
		
		return "/stu/gradeStudent";
	}

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String goToProfile(HttpServletRequest request, HttpServletResponse response, 
			HttpSession session, Map<String, Object> model) {
		String userID = (String) session.getAttribute("userID");
		
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

		model.put("courseNum", courses == null ? 0 : courses.size());
		model.put("messageNum", messages == null ? 0 : messages.size());
		model.put("assignmentNum", assignments == null ? 0 : assignments.size());

		model.put("userCourses", courses);
		model.put("userMessages", messages);
		model.put("userAssignemnts", assignments);
		
		return "/profile";
	}
	
//	@RequestMapping(value = "/logout", method = RequestMethod.GET)
//	public String logout(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
//		session.invalidate();
//		return "login";
//	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		session.invalidate();
		return "/login";
	}

	@RequestMapping(value = "/resetPWD", method = RequestMethod.GET)
	public String resetPassword(HttpServletRequest request, HttpServletResponse response) {
		
		
		return "passwordReset";
	}
}
