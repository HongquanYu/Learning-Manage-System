

package com.umd.ezcomm.model.dao.service.impl;

import java.rmi.server.UID;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
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
		String query = "SELECT COUNT(*) FROM AssignmentList " + 
				"WHERE CourseID = (" + 
				"SELECT CourseID FROM CourseList\n" + 
				"WHERE UID = '" + userID + "');";
		return template.queryForObject(query, Integer.class);
	}

	@Override
	public List<Assignment> getAssignments(String userID) {
		
		return null;
	}
}
