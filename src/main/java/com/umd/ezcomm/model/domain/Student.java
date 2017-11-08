package com.umd.ezcomm.model.domain;

import java.util.List;

/** @author: Hongquan Yu
 *  @date: Oct 29, 2017
 *
 *  @From: University of Maryland, College Park
 *  @Email: hyu12346@terpmail.umd.edu
 */
public class Student extends User{
	private String id;
	private String name;
	private int GPA;
	private List<Course> courses;
}