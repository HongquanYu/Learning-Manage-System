package com.umd.ezcomm.model.dao.impl;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import com.umd.ezcomm.model.CourseInfo;
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
	public String getCourseName(int cID) {
		String SQL = "SELECT Name FROM Courses WHERE ID = \"" + cID + "\";";
		
		String name = template.queryForObject(SQL, String.class);

		return name;
	}

	@Override
	public List<CourseInfo> getCourseList() {
		// TODO Auto-generated method stub
		return null;
	}
}
