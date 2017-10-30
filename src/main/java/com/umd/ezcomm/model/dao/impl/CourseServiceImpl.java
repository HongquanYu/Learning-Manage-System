package com.umd.ezcomm.model.dao.impl;

import java.io.File;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import com.umd.ezcomm.model.Assignment;
import com.umd.ezcomm.model.Course;
import com.umd.ezcomm.model.CourseInfo;
import com.umd.ezcomm.model.Student;
import com.umd.ezcomm.model.dao.service.CourseService;

/** @author: Hongquan Yu
 *  @date: Oct 29, 2017
 *
 *  @From: University of Maryland, College Park
 *  @Email: hyu12346@terpmail.umd.edu
 */

public class CourseServiceImpl implements CourseService{
	
	private JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	@Override
	public String getID(String name) {
		String SQL = "SELECT ID FROM Courses WHERE Name = \"" + name + "\";";
		
		String courseID = template.queryForObject(SQL, String.class);

		return courseID;
	}

	@Override
	public String getName(String id) {
		String SQL = "SELECT Name FROM Courses WHERE ID = \"" + id + "\";";
		
		String name = template.queryForObject(SQL, String.class);

		return name;
	}

	@Override
	public String getInstructorByID(String cid) {
		String SQL = "SELECT * FROM User WHERE UID = (SELECT InstructorID FROM Courses WHERE ID = \"" + cid + "\");";
		
		String courseID = template.queryForObject(SQL, String.class);

		return courseID;
	}

	@Override
	public List<Assignment> getAssignments(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<File> getFiles(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public File getSyllabus(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> getStudents(String name) {
		// TODO Auto-generated method stub
		return null;
	}
}
