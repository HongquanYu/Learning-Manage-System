package com.umd.ezcomm.model.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import com.umd.ezcomm.model.dao.service.CourseService;

/** @author: Hongquan Yu
 *  @date: Oct 29, 2017
 *
 *  @From: University of Maryland, College Park
 *  @Email: hyu12346@terpmail.umd.edu
 */
public class CourseServiceImpl implements CourseService{
	
	private JdbcTemplate template;
	
	@Override
	public String getCourseName(int cID) {
		String SQL = "SELECT Name FROM Courses WHERE ID = \"" + cID + "\";";
		
		String name = template.queryForObject(SQL, String.class);

		return name;
	}

}
