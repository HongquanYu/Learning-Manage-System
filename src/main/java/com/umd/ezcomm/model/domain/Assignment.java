package com.umd.ezcomm.model.domain;

import java.sql.Date;

/** @author: Hongquan Yu
 *  @date: Oct 29, 2017
 *
 *  @From: University of Maryland, College Park
 *  @Email: hyu12346@terpmail.umd.edu
 */
public class Assignment {
	private String id;
	private Date due;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDue() {
		return due;
	}

	public void setDue(Date due) {
		this.due = due;
	}
}
