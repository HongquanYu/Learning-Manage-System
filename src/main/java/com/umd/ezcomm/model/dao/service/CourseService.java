package com.umd.ezcomm.model.dao.service;

import java.io.File;
import java.util.List;
import com.umd.ezcomm.model.Assignment;
import com.umd.ezcomm.model.Course;
import com.umd.ezcomm.model.Student;

/** @author: Hongquan Yu
 *  @date: Oct 29, 2017
 *
 *  @From: University of Maryland, College Park
 *  @Email: hyu12346@terpmail.umd.edu
 */
public interface CourseService {
	public String getID(String name);
	public String getName(String id);
	public String getInstructorByID(String name);
	public List<Assignment> getAssignments(String name);
	public List<File> getFiles(String name);
	public File getSyllabus(String name);
	public List<Student> getStudents(String name);
}
