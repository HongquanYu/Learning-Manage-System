package com.umd.ezcomm.model.dao.service;

import java.sql.Date;
import java.util.List;
import java.util.Set;
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
	
	public List<Assignment> getAssignmentGrade(String userID);
	
	public Set<Assignment> getTodoAssignmentByCourseID(String userID, String courseID);
	
	public Set<Assignment> getDoneAssignmentByCourseID(String userID, String courseID);
	
	public boolean insertAssignment(String userID, String courseID, String assiName, String due);
	
	public boolean insertGrade(String userID, String assignmentID, int grade);
	
}
