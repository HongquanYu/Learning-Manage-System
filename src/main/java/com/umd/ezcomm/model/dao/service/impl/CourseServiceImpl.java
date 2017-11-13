package com.umd.ezcomm.model.dao.service.impl;

import java.io.File;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.umd.ezcomm.model.dao.service.CourseService;
import com.umd.ezcomm.model.domain.Assignment;
import com.umd.ezcomm.model.domain.Student;

/** @author: Hongquan Yu
 *  @date: Oct 29, 2017
 *
 *  @From: University of Maryland, College Park
 *  @Email: hyu12346@terpmail.umd.edu
 */

@Service
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
		
		return null;
	}

	@Override
	public List<File> getFiles(String name) {
		
		return null;
	}

	@Override
	public File getSyllabus(String name) {
		
		return null;
	}

	@Override
	public List<Student> getStudents(String name) {
		
		return null;
	}
}
