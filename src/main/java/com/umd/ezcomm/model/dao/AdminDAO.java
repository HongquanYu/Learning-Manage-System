package com.umd.ezcomm.model.dao;

import com.umd.ezcomm.model.Admin;
import com.umd.ezcomm.model.User;

/** @author: Hongquan Yu
 *  @date: Oct 10, 2017
 *
 *  @From: University of Maryland
 *  @Email: hyu12346@terpmail.umd.edu
 */
public interface AdminDAO {
	public boolean userAuth(String uname, String psd);
	
	public void insert(Admin user);
	public User findByUserID(int userID);
	public User findByUserName(String name);
	public int findByTel(int tel);
	public User getProfile(String name);
	public int getGPAbyName(String name);
	public int getGPAbyUserID(int id);
	
	public boolean updateUserName(String name);
	public boolean updateUserPassword(String psd);
	public boolean updateUserEmail(String email);
}
