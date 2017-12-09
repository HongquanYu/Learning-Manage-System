package com.umd.ezcomm.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.umd.ezcomm.model.dao.service.impl.FileManagementImpl;

@Controller
public class AssignmentController {

	private final String courseIdRegex = "[A-Za-z]{4}\\d{1,3}[A-Za-z]?";

	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

	FileManagementImpl fileService = (FileManagementImpl) context.getBean("FileManagementImpl");

	@RequestMapping(value = "/ins/instructorTabs/storeAssignment", method = RequestMethod.POST)
	public void uploadInstructorAssignment(@RequestParam("file") MultipartFile multipartFile,
			@RequestParam("filename") String fileName, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) throws IOException {

		String lReturnString = "";
		String lFileName = request.getParameter("filename");
		System.out.println("Storing Assignment by Instructor " + lFileName);

		if (!"application/pdf".equals(multipartFile.getContentType())) {
			lReturnString = "File must be in a pdf format, please check the file type";
		} else {
			fileName = fileName + ".pdf";

			lReturnString = fileService.storeAssignment(multipartFile, fileName);
			System.out.println("File Name: " + fileName);

		}

		int lResponseStatus = 200;
		response.setContentType("text/html;charset=UTF-8");
		response.setStatus(lResponseStatus);
		PrintWriter lPrintWriter = response.getWriter();
		lPrintWriter.write(lReturnString);
		lPrintWriter.flush();
		lPrintWriter.close();
	}

	@RequestMapping(value = "/ins/studentTabs/storeAssignment", method = RequestMethod.POST)
	public void uploadStudentAssignment(@RequestParam("file") MultipartFile multipartFile,
			@RequestParam("filename") String fileName, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) throws IOException {

		String lFileName = request.getParameter("filename");
		System.out.println("Strong Assignment by Student " + lFileName);
		String lReturnString = "";

		if (!"application/pdf".equals(multipartFile.getContentType())) {
			lReturnString = "File must be in a pdf format, please check the file type";
		} else {
			fileName = fileName + ".pdf";

			lReturnString = fileService.storeAssignment(multipartFile, fileName);
			System.out.println("File Name: " + fileName);

		}

		int lResponseStatus = 200;
		response.setContentType("text/html;charset=UTF-8");
		response.setStatus(lResponseStatus);
		PrintWriter lPrintWriter = response.getWriter();
		lPrintWriter.write(lReturnString);
		lPrintWriter.flush();
		lPrintWriter.close();
	}

	@RequestMapping(value = "/ins/instructorTabs/downloadAssignment", method = RequestMethod.GET)
	public ResponseEntity<byte[]> downloadFile(HttpServletRequest request, HttpSession session,
			HttpServletResponse response, Map<String, Object> model,
			@ModelAttribute(value = "filename") String filename, @ModelAttribute(value = "courseId") String courseId,
			@ModelAttribute(value = "userId") String userId) {

		System.out.println(
				"Downloading Assignment by Instructor " + filename + " , courseId " + courseId + " , userId " + userId);

		String lFileName = courseId + "-" + filename + "-" + userId;
		HttpHeaders lHeaders = new HttpHeaders();
		lHeaders.setContentType(MediaType.parseMediaType("application/pdf"));
		lHeaders.setContentDispositionFormData(lFileName + ".pdf", lFileName + ".pdf");
		lHeaders.setCacheControl("must revalidate, post-check=0, pre-check=0");
		byte[] lFileData = fileService.retrieveAssignment(lFileName);
		return new ResponseEntity<byte[]>(lFileData, lHeaders, HttpStatus.OK);

	}

	@RequestMapping(value = "/stu/studentTabs/downloadAssignment", method = RequestMethod.GET)
	public ResponseEntity<byte[]> downloadFileStudent(HttpServletRequest request, HttpSession session,
			HttpServletResponse response, Map<String, Object> model,
			@ModelAttribute(value = "filename") String lFileName, @ModelAttribute(value = "courseId") String courseId) {

		System.out.println("Downloading Assignment by Student filename: " + lFileName);
		System.out.println("Downloading Assignment by Student courseId: " + courseId);

		HttpHeaders lHeaders = new HttpHeaders();

		lFileName = courseId + "-" + lFileName;
		lHeaders.setContentType(MediaType.parseMediaType("application/pdf"));
		lHeaders.setContentDispositionFormData(lFileName + ".pdf", lFileName + ".pdf");
		lHeaders.setCacheControl("must revalidate, post-check=0, pre-check=0");
		byte[] lFileData = fileService.retrieveAssignment("", lFileName);

		return new ResponseEntity<byte[]>(lFileData, lHeaders, HttpStatus.OK);

	}

}
