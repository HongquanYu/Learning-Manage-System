package com.umd.ezcomm.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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

	private final String courseIdRegex = "[A-Za-z]{4}\\d{1,3}[A-Za-z]?";
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

		if (ue == null) {
			return "/login";
		} else {
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
	}

	@RequestMapping(value = "/ins/instructorHome", method = RequestMethod.GET)
	public String instructorHomepage(HttpServletRequest request, HttpSession session, Map<String, Object> model) {

		String ue = (String) session.getAttribute("userEmail");

		if (ue == null) {
			return "/login";
		} else {
			String userID = userService.getUID(ue);

			List<Course> courseList = instructorService.getCourseList(userID);

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
			model.put("enrolledCourses", courseList);

			return "/ins/instructorHome";
		}

	}

	/* user authentication and load data. */

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String userLogin(HttpServletRequest request, HttpSession session, Map<String, Object> model) {
		String ue = request.getParameter("userEmail");

		if (ue == null) {
			return "/login";
		} else {

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
				return isStudent ? "redirect:stu/studentHome.html"
						: "redirect:ins/instructorHome.html";
			}
		}
	}

	@RequestMapping(value = "/ins/instructorTabs", method = RequestMethod.GET)
	public String goToInstructorTabs(HttpServletRequest request, HttpSession session, HttpServletResponse response,
			Map<String, Object> model) {

		String userID = (String) session.getAttribute("userID");

		if (userID == null) {
			return "/login";
		} else {
			List<Course> courseList = instructorService.getCourseList(userID);
			List<Student> studentList = new LinkedList<>();

			List<Course> courses = null;
			List<Message> messages = null;
			List<Assignment> assignments = null;

			try {
				courses = userService.courseEnrolled(userID);
				messages = userService.messageReceived(userID);
				assignments = studentService.getAssignments(userID);
				for (Course c : courseList) {
					studentList.addAll(instructorService.getStudentList(c.getID()));
				}

			} catch (Exception e) {
				log.info("data access error.");
				model.put("dataException", true);
			}

			model.put("studentList", studentList);
			model.put("userCourses", courses);
			model.put("userMessages", messages);
			model.put("userAssignemnts", assignments);

			return "/ins/instructorTabs";
		}
	}

	@RequestMapping(value = "/ins/instructorTabs/{courseId:" + courseIdRegex + "}", method = RequestMethod.GET)
	public String goToInstructorCourse(HttpServletRequest request, HttpSession session, HttpServletResponse response,
			Map<String, Object> model, @PathVariable("courseId") String courseId) {

		System.out.println("Made it to specific course");
		String ue = (String) session.getAttribute("userEmail");

		if (ue == null || courseId == null || courseId.trim().equals("")) {
			return "/login";
		} else {

			// check user access
			String userID = userService.getUID(ue);

			boolean authorizedToLookAtCourse = false;
			List<Course> courseList = instructorService.getCourseList(userID);
			for (Course c : courseList) {
				if (c.getID().equals(courseId)) {
					authorizedToLookAtCourse = true;
				}
			}

			// User does not have permission to access
			if (!authorizedToLookAtCourse) {
				return "error.html";
			}
			model.put("courseId", courseId);
			model.put("enrolledCourses", courseList);

			return "/ins/instructorTabs";
		}

	}

	@RequestMapping(value = "/ins/instructorTabs/downloadFile", method = RequestMethod.GET)
	public String downloadFile(HttpServletRequest request, HttpSession session, HttpServletResponse response,
			Map<String, Object> model) {

		System.out.println("made it to download file");
		System.out.println("File Name: " + request.getParameter("fileName"));
		return "/ins/instructorTabs";
	}

	@RequestMapping(value = "/stu/studentTabs", method = RequestMethod.GET)
	public String goToStudentTabs(HttpServletRequest request, HttpSession session, HttpServletResponse response,
			Map<String, Object> model) {
		String userID = (String) session.getAttribute("userID");

		if (userID == null) {
			return "/login";
		} else {

			List<Assignment> assignmentGradeList = new LinkedList<>();

			List<Course> courses = null;
			List<Message> messages = null;
			List<Assignment> assignments = null;

			try {
				courses = userService.courseEnrolled(userID);
				messages = userService.messageReceived(userID);
				assignments = studentService.getAssignments(userID);
				assignmentGradeList = studentService.getAssignmentGrade(userID);

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
			model.put("assignmentGradeList", assignmentGradeList);

			return "/stu/studentTabs";
		}
	}

	@RequestMapping(value = "/ins/gradeProfessor", method = RequestMethod.GET)
	public String goToInstructorGradePage(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			Map<String, Object> model) {
		String userID = (String) session.getAttribute("userID");

		if (userID == null) {
			return "/login";
		} else {

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
	}

	@RequestMapping(value = "/stu/gradeStudent", method = RequestMethod.GET)
	public String goToGrade(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			Map<String, Object> map) {
		String userID = (String) session.getAttribute("userID");

		if (userID == null) {
			return "/login";
		} else {

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
	}

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String goToProfile(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			Map<String, Object> model) {
		String userID = (String) session.getAttribute("userID");

		if (userID == null) {
			return "/login";
		} else {

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
	}


	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		session.invalidate();
		return "/login";
	}

	@RequestMapping(value = "/ins/storeFile", method = RequestMethod.POST)
	public void uploadFile(@RequestParam("file") MultipartFile multipartFile, @RequestParam("filename") String fileName,
			HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {

		String lReturnString = "";

		if (!"application/pdf".equals(multipartFile.getContentType())) {
			lReturnString = "File must be in a pdf format, please check the file type";
		} else {
			fileName = fileName + ".pdf";

			System.out.println("File Name: " + fileName);
			if (multipartFile.getBytes() != null) {
				File f = new File(fileName);
				if (f.exists() && !f.isDirectory()) {
					lReturnString = "Replaced previous syllabus with new file";
				} else {
					lReturnString = "Successfully uploaded syllabus";
				}
				writeFile(fileName, multipartFile);
			}
		}

		int lResponseStatus = 200;
		response.setContentType("text/html;charset=UTF-8");
		response.setStatus(lResponseStatus);
		PrintWriter lPrintWriter = response.getWriter();
		lPrintWriter.write(lReturnString);
		lPrintWriter.flush();
		lPrintWriter.close();
	}

	public void writeFile(String filename, MultipartFile file) throws IOException {
		File fileToBeWritten = new File(filename);
		fileToBeWritten.createNewFile();
		FileOutputStream fos = new FileOutputStream(fileToBeWritten, false);
		fos.write(file.getBytes());
		fos.close();
	}

	@RequestMapping(value = "/resetPWD", method = RequestMethod.GET)
	public String resetPassword(HttpServletRequest request, HttpServletResponse response) {

		return "passwordReset";
	}
}
