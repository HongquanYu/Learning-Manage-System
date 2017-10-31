package com.umd.ezcomm.model.domain;

import java.io.File;
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
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	public List<Assignment> getAssignment() {
		return assignment;
	}
	public void setAssignment(List<Assignment> assignment) {
		this.assignment = assignment;
	}
	public List<File> getFile() {
		return file;
	}
	public void setFile(List<File> file) {
		this.file = file;
	}
	public File getSyllabus() {
		return syllabus;
	}
	public void setSyllabus(File syllabus) {
		this.syllabus = syllabus;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}	
}
