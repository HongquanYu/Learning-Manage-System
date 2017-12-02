package com.umd.ezcomm.model.dao.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import com.umd.ezcomm.model.dao.service.StudentService;
import com.umd.ezcomm.model.domain.Assignment;

/** @author: Hongquan Yu
 *  @date: Nov 6, 2017
 *
 *  @From: University of Maryland, College Park
 *  @Email: hyu12346@terpmail.umd.edu
 */

@Service
public class StudentServiceImpl implements StudentService{

	private static final Logger log = LogManager.getLogger();
	
	private JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	@Override
	public int getGPA(String name) {
		
		return 0;
	}

	@Override
	public int getAssignmentNum(String userID) {
		
		String query = "SELECT COUNT(*) FROM AssignmentList AL " + 
				"INNER JOIN CourseList CL ON AL.CourseID = CL.CourseID " +
				"INNER JOIN Assignment A ON AL.AssignmentID = A.ID " +
				"WHERE CL.UID = " + userID;

		int num = 0;
		
		try {
			num = template.queryForObject(query, Integer.class);
		} catch (DataAccessException e) {
			log.info("Data access exception, cannot access data correctly.");
		}
		
		return num;
	}

	@Override
	public List<Assignment> getAssignments(String userID) {
		
		String SQL = "SELECT A.ID, A.DueDate FROM Assignment A " + 
				"INNER JOIN AssignmentList AL  ON AL.AssignmentID = A.ID " + 
				"INNER JOIN CourseList CL ON AL.CourseID = CL.CourseID " + 
				"WHERE A.Published = 1 AND CL.UID = '" + userID + "';";
		
		List<Assignment> assignment = template.query(SQL, new RowMapper<Assignment>() {
			@Override
			public Assignment mapRow(ResultSet rs, int rowNum) throws SQLException {
				Assignment a = new Assignment();
				
				a.setId(rs.getString("ID"));
				a.setDue(rs.getDate("DueDate"));
				
				return a;
			}
		});
		
		return assignment;
	}

	@Override
	public List<Assignment> getAssignmentGrade(String userID) {
		String SQL = "SELECT AL.AssignmentID, AG.Grade, C.Name " + 
				"FROM ((AssignmentList AL " + 
				"INNER JOIN  AssignmentGrade AG ON AG.AssignmentID = AL.AssignmentID) " + 
				"INNER JOIN Courses C ON AL.CourseID = C.ID) " + 
				"WHERE AG.StudentID = '" + userID + "';";
		
		List<Assignment> assignment = template.query(SQL, new RowMapper<Assignment>() {
			@Override
			public Assignment mapRow(ResultSet rs, int rowNum) throws SQLException {
				Assignment a = new Assignment();
				
				a.setId(rs.getString("AssignmentID"));
				a.setGrade(rs.getInt("Grade"));
				a.setCourseName(rs.getString("Name"));
				
				return a;
			}
		});
		
		return assignment;
	}
}
