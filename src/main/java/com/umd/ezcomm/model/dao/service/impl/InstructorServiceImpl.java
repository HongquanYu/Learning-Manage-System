package com.umd.ezcomm.model.dao.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import com.umd.ezcomm.model.dao.service.InstructorService;
import com.umd.ezcomm.model.dao.service.UserService;
import com.umd.ezcomm.model.domain.Course;
import com.umd.ezcomm.model.domain.Student;

/** @author: Hongquan Yu
 *  @date: Dec 1, 2017
 *
 *  @From: University of Maryland, College Park
 *  @Email: hyu12346@terpmail.umd.edu
 */

@Service
public class InstructorServiceImpl implements InstructorService {
	
	@SuppressWarnings("unused")
	private static final Logger log = LogManager.getLogger();
	
	private JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	@Override
	public List<Student> getStudentList(String courseID) {
		String SQL = "SELECT U.UID, U.Name AS uName, U.Email, C.Name AS cName " + 
				"FROM ((CourseList  CL " + 
				"INNER JOIN User U ON U.UID = CL.UID) " + 
				"INNER JOIN Courses C ON C.ID = CL.CourseID) " + 
				"WHERE CL.CourseID = '" + courseID + "';";
		
		List<Student> stu = template.query(SQL, new RowMapper<Student>() {
			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student s = new Student();
				
				s.setUserID(rs.getString("UID"));
				s.setName(rs.getString("uName"));
				s.setEmail(rs.getString("Email"));
				String cName = rs.getString("cName");
				
				HashMap<String, String> cou = new HashMap<>();
				cou.put(cName, s.getUserID());
				
				s.setCourses(cou);
				
				return s;
			}
		});
		
		return stu;
	}

	@Override
	public List<Course> getCourseList(String userID) {
		String SQL = "SELECT C.ID, C.Name AS cName, C.Description " + 
				"FROM Courses  C " + 
				"INNER JOIN CourseList CL ON C.ID = CL.CourseID " + 
				"WHERE  CL.UID = '" + userID + "';";
		
		List<Course> course = template.query(SQL, new RowMapper<Course>() {
			@Override
			public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
				Course cou = new Course();
				
				cou.setID(rs.getString("ID"));
				cou.setName(rs.getString("cName"));
				cou.setDescription(rs.getString("Description"));
				
				return cou;
			}
		});
		
		return course;
	}
}
