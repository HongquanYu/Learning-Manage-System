package com.umd.ezcomm.model.dao;

import com.umd.ezcomm.model.User;

/** @author: Hongquan Yu
 *  @date: Oct 9, 2017
 *
 *  @From: University of Maryland
 *  @Email: hyu12346@terpmail.umd.edu
 */
public interface UserDAO {
	public void insert(User user);
	public User findByUserID(int userID);
	public boolean isLegalUser(String username, String password);
}
