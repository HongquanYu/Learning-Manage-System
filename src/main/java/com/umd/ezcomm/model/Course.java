package com.umd.ezcomm.model;

import java.util.List;

/** @author: Hongquan Yu
 *  @date: Oct 29, 2017
 *
 *  @From: University of Maryland, College Park
 *  @Email: hyu12346@terpmail.umd.edu
 */
public class Course {
	private String ID;
	private String Name;
	private String instructor;
	private List<Assignment> assignment;
	private List<File> file;
	private File syllabus;
	private List<Student> students;
}
