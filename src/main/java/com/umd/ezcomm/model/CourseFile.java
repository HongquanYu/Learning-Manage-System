package com.umd.ezcomm.model;

import java.io.File;

/** @author: Hongquan Yu
 *  @date: Oct 29, 2017
 *
 *  @From: University of Maryland, College Park
 *  @Email: hyu12346@terpmail.umd.edu
 */
public class CourseFile {
	private String id;
	private String name;
	private File file;		// file object, mediumblob in mysql
	private String courseID;
	private boolean published;
}
