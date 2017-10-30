package com.umd.ezcomm.model.dao.service;

import java.util.List;
import com.umd.ezcomm.model.CourseInfo;

/** @author: Hongquan Yu
 *  @date: Oct 29, 2017
 *
 *  @From: University of Maryland, College Park
 *  @Email: hyu12346@terpmail.umd.edu
 */
public interface CourseService {
	public String getCourseName(int cID);
	
	public List<CourseInfo> getCourseList();
}
