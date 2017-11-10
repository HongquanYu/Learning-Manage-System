

package com.umd.ezcomm.model.dao.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import com.mysql.jdbc.log.Log;
import com.umd.ezcomm.model.dao.service.StudentService;
import com.umd.ezcomm.model.domain.Assignment;
import com.umd.ezcomm.model.domain.Course;

/** @author: Hongquan Yu
 *  @date: Nov 6, 2017
 *
 *  @From: University of Maryland, College Park
 *  @Email: hyu12346@terpmail.umd.edu
 */
@Service
public class StudentServiceImpl implements StudentService{
	
	@SuppressWarnings("unused")
	private static final Logger log = LogManager.getLogger();
	
	@SuppressWarnings("unused")
	private JdbcTemplate template;
	private NamedParameterJdbcTemplate temp;
	
	public void setTemp(NamedParameterJdbcTemplate temp) {
		this.temp = temp;
	}
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	@Override
	public int getGPA(String name) {
		
		return 0;
	}

	@Override
	public int getAssignmentNum(String userID) {
		System.out.println("userID: " + userID);
		String query = "SELECT COUNT(*) FROM AssignmentList AL " + 
				"INNER JOIN CourseList CL " + 
				"ON AL.CourseID = CL.CourseID " +
				"INNER JOIN Assignment A " + 
				"ON AL.AssignmentID = A.ID " +
				"WHERE CL.UID = :userID";
		
		Map<String, String> paraMaps = new HashMap<>();
		paraMaps.put("userID", userID);
		System.out.println("SQL: " + query);
		
		int num = 0;
		
		try {
			num = temp.queryForInt(query, paraMaps);
		} catch (DataAccessException e) {
			log.info("Data access exception, cannot access data correctly.");
			
			
		}
		
		return num;
	}

	@Override
	public List<Assignment> getAssignments(String userID) {
		
		return null;
	}
}
