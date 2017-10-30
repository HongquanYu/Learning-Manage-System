package com.umd.ezcomm.model.dao.service;

/** @author: Hongquan Yu
 *  @date: Oct 10, 2017
 *
 *  @From: University of Maryland
 *  @Email: hyu12346@terpmail.umd.edu
 */
public interface UserService {
	public String getUID(String name);
	public boolean userAuth(String n, String p);
	public boolean updatePassword(String n, String p);
	public boolean updateEmail(String n, String email);
	public boolean updateStatus(String n, String status);
}
