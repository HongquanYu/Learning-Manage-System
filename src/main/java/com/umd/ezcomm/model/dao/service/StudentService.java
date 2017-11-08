package com.umd.ezcomm.model.dao.service;

import java.util.List;
import com.umd.ezcomm.model.domain.Assignment;

/** @author: Hongquan Yu
 *  @date: Oct 30, 2017
 *
 *  @From: University of Maryland, College Park
 *  @Email: hyu12346@terpmail.umd.edu
 */
public interface StudentService {
	
	public int getGPA(String name);
	
	public int getAssignmentNum(String userID);
	
	public List<Assignment> getAssignments(String userID);
}
