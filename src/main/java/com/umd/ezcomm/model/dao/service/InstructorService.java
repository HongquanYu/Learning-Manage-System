package com.umd.ezcomm.model.dao.service;

import java.util.List;
import com.umd.ezcomm.model.domain.Course;
import com.umd.ezcomm.model.domain.CourseGrade;
import com.umd.ezcomm.model.domain.Student;

/** @author: Hongquan Yu
 *  @date: Dec 1, 2017
 *
 *  @From: University of Maryland, College Park
 *  @Email: hyu12346@terpmail.umd.edu
 */
public interface InstructorService {
	
	public List<Student> getStudentList(String courseID);
	
	public List<Course> getCourseList(String userID);
	public List<CourseGrade> getCourseGradebook(String userID);
	public void insertAssignment(String assignID);
	public void gradeAssignment(String courseID, String stuID, String assignName, int grade, String comment);
}
