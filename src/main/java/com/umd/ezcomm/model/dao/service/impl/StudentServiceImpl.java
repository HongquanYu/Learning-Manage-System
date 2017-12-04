package com.umd.ezcomm.model.dao.service.impl;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
		
		String SQL = "SELECT A.ID, A.CreateTime, A.DueDate, AG.Grade, CL.CourseID FROM Assignment A " + 
				"INNER JOIN AssignmentList AL ON AL.AssignmentID = A.ID " + 
				"INNER JOIN CourseList CL ON AL.CourseID = CL.CourseID " + 
				"INNER JOIN AssignmentGrade AG ON AG.AssignmentID = AL.AssignmentID " +
				"WHERE A.Published = 1 AND CL.UID = '" + userID + "';";
		
		List<Assignment> assignment = template.query(SQL, new RowMapper<Assignment>() {
			@Override
			public Assignment mapRow(ResultSet rs, int rowNum) throws SQLException {
				Assignment a = new Assignment();
				
				a.setId(rs.getString("ID"));
				a.setDue(rs.getDate("DueDate"));
				a.setPublishTime(rs.getDate("CreateTime"));
				a.setCourseID(rs.getString("CourseID"));
				a.setGrade(rs.getInt("Grade"));
				
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

	@Override
	public Set<Assignment> getTodoAssignmentByCourseID(String userID, String courseID) {
		String SQL = "SELECT A.ID, A.CreateTime, A.DueDate " + 
				"FROM Assignment A " + 
				"INNER JOIN AssignmentList AL ON AL.AssignmentID = A.ID " + 
				"INNER JOIN CourseList CL ON AL.CourseID = CL.CourseID " + 
				"WHERE  A.Published = 1 AND CL.UID = '" + userID + 
				"' AND CL.CourseID= '" + courseID + "' AND A.isSubmitted= '0';";
		
		List<Assignment> assignment = template.query(SQL, new RowMapper<Assignment>() {
			@Override
			public Assignment mapRow(ResultSet rs, int rowNum) throws SQLException {
				Assignment a = new Assignment();
				
				a.setId(rs.getString("ID"));
				a.setPublishTime(rs.getDate("CreateTime"));
				a.setDue(rs.getDate("DueDate"));
				
				return a;
			}
		});
		Set<Assignment> resultSet = new HashSet<>();
		resultSet.addAll(assignment);
		
		return resultSet;
	}
	
	
	@Override
	public Set<Assignment> getDoneAssignmentByCourseID(String userID, String courseID) {
		String SQL = "SELECT A.ID, A.CreateTime, A.DueDate, AG.Grade " + 
				"FROM Assignment A " + 
				"INNER JOIN AssignmentList AL ON AL.AssignmentID = A.ID " + 
				"INNER JOIN CourseList CL ON AL.CourseID = CL.CourseID " + 
				"INNER JOIN AssignmentGrade AG ON AG.AssignmentID = A.ID " +
				"WHERE  A.Published = '1' AND CL.UID = '" + userID + 
				"' AND CL.CourseID= '" + courseID + 
				"' AND A.isSubmitted= '1';";
		
		List<Assignment> assignment = template.query(SQL, new RowMapper<Assignment>() {
			@Override
			public Assignment mapRow(ResultSet rs, int rowNum) throws SQLException {
				Assignment a = new Assignment();
				
				a.setId(rs.getString("ID"));
				a.setPublishTime(rs.getDate("CreateTime"));
				a.setDue(rs.getDate("DueDate"));
				a.setGrade(rs.getInt("Grade"));
				
				return a;
			}
		});
		
		Set<Assignment> resultSet = new HashSet<>();
		resultSet.addAll(assignment);
		
		return resultSet;
	}
	
	/* Insert a new assgnment name and  */
	
	@Override
	public boolean insertAssignment(String userID, String courseID, String assiName, String due) {
		String query = "INSERT INTO Assignment (ID, isSubmitted, Published, CreateTime, DueDate) " + 
				"VALUES ('" + assiName + "', '" + assiName + "', 1, CURDATE(), CURDATE());";
		
		return template.update(query) == 1;
	}

	/* Insert a grade for a new assignment  */
	
	@Override
	public boolean insertGrade(String userID, String assignmentID, int grade) {
		String query = "INSERT INTO AssignmentGrade (StudentID, AssignmentID, Grade) " + 
				"VALUES ('" + userID + "', '" + assignmentID + "', '" + grade +"');";
		return false;
	}
}
