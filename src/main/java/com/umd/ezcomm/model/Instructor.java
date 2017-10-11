package com.umd.ezcomm.model;

/** @author: Hongquan Yu
 *  @date: Oct 10, 2017
 *
 *  @From: University of Maryland
 *  @Email: hyu12346@terpmail.umd.edu
 */
public class Instructor {
	private int insID;
	private String iname;
	private int iage;
	private String iusername;
	private String ipassword;
	private String iemail;
	private String imajor;
	private String igender;
	private String ibday;
	
	/**
	 * 
	 */
	public Instructor() {
		super();
	}
	/**
	 * @param iusername
	 * @param ipassword
	 */
	public Instructor(String iusername, String ipassword) {
		super();
		this.iusername = iusername;
		this.ipassword = ipassword;
	}
	/**
	 * @return the insID
	 */
	public int getInsID() {
		return insID;
	}
	/**
	 * @param insID the insID to set
	 */
	public void setInsID(int insID) {
		this.insID = insID;
	}
	/**
	 * @return the iname
	 */
	public String getIname() {
		return iname;
	}
	/**
	 * @param iname the iname to set
	 */
	public void setIname(String iname) {
		this.iname = iname;
	}
	/**
	 * @return the iage
	 */
	public int getIage() {
		return iage;
	}
	/**
	 * @param iage the iage to set
	 */
	public void setIage(int iage) {
		this.iage = iage;
	}
	/**
	 * @return the iusername
	 */
	public String getIusername() {
		return iusername;
	}
	/**
	 * @param iusername the iusername to set
	 */
	public void setIusername(String iusername) {
		this.iusername = iusername;
	}
	/**
	 * @return the ipassword
	 */
	public String getIpassword() {
		return ipassword;
	}
	/**
	 * @param ipassword the ipassword to set
	 */
	public void setIpassword(String ipassword) {
		this.ipassword = ipassword;
	}
	/**
	 * @return the iemail
	 */
	public String getIemail() {
		return iemail;
	}
	/**
	 * @param iemail the iemail to set
	 */
	public void setIemail(String iemail) {
		this.iemail = iemail;
	}
	/**
	 * @return the imajor
	 */
	public String getImajor() {
		return imajor;
	}
	/**
	 * @param imajor the imajor to set
	 */
	public void setImajor(String imajor) {
		this.imajor = imajor;
	}
	/**
	 * @return the igender
	 */
	public String getIgender() {
		return igender;
	}
	/**
	 * @param igender the igender to set
	 */
	public void setIgender(String igender) {
		this.igender = igender;
	}
	/**
	 * @return the ibday
	 */
	public String getIbday() {
		return ibday;
	}
	/**
	 * @param ibday the ibday to set
	 */
	public void setIbday(String ibday) {
		this.ibday = ibday;
	}
}
