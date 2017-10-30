package com.umd.ezcomm.model.dao.service;

import java.util.List;
import com.umd.ezcomm.model.Course;

/** @author: Hongquan Yu
 *  @date: Oct 30, 2017
 *
 *  @From: University of Maryland, College Park
 *  @Email: hyu12346@terpmail.umd.edu
 */
public interface StudentService {
	public int getGPA(String name);
	public List<Course> courseEnrolled(String name);
}
