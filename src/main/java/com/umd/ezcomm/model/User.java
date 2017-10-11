package com.umd.ezcomm.model;

/** @author: Hongquan Yu
 *  @date: Oct 9, 2017
 *
 *  @From: University of Maryland
 *  @Email: hyu12346@terpmail.umd.edu
 */
public class User {
	private int userID;
	private String name;
	private int age;
	private String username;
	private String password;
	private String email;
	private String major;
	private String gender;
	private String bday;
	
	
	/**
	 * @param username
	 * @param password
	 */
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	/**
	 * @param userID
	 * @param name
	 * @param age
	 */
	public User(int userID, String name, int age) {
		super();
		this.userID = userID;
		this.name = name;
		this.age = age;
	}
	
	
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * @return the userID
	 */
	public int getUserID() {
		return userID;
	}

	/**
	 * @param userID the userID to set
	 */
	public void setUserID(int userID) {
		this.userID = userID;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the major
	 */
	public String getMajor() {
		return major;
	}

	/**
	 * @param major the major to set
	 */
	public void setMajor(String major) {
		this.major = major;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the bday
	 */
	public String getBday() {
		return bday;
	}

	/**
	 * @param bday the bday to set
	 */
	public void setBday(String bday) {
		this.bday = bday;
	}
}
