package com.umd.ezcomm.model.domain;

import java.util.HashMap;
import java.util.List;

/** @author: Hongquan Yu
 *  @date: Oct 29, 2017
 *
 *  @From: University of Maryland, College Park
 *  @Email: hyu12346@terpmail.umd.edu
 */
public class Student extends User{
	
	private String name;
	private int GPA;
	private List<Course> courseList;
	private HashMap<String, String> courses;		// CourseID - StudentID
	
	
	public List<Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGPA() {
		return GPA;
	}

	public void setGPA(int gPA) {
		GPA = gPA;
	}

	public HashMap<String, String> getCourses() {
		return courses;
	}

	public void setCourses(HashMap<String, String> courses) {
		this.courses = courses;
	}

}
