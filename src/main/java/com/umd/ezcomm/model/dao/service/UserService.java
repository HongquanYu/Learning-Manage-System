package com.umd.ezcomm.model.dao.service;

/** @author: Hongquan Yu
 *  @date: Oct 10, 2017
 *
 *  @From: University of Maryland
 *  @Email: hyu12346@terpmail.umd.edu
 */
public interface UserService {
	public long getNum();
	public boolean userAuth(String uname, String psd);
	public boolean updatePassword(String pwd);
	public boolean updateEmail(String email);
	public boolean updateStatus(String status);
}
