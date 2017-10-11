package com.umd.ezcomm.model.dao.impl;

import com.umd.ezcomm.model.User;
import com.umd.ezcomm.model.dao.InstructorDAO;

/** @author: Hongquan Yu
 *  @date: Oct 10, 2017
 *
 *  @From: University of Maryland
 *  @Email: hyu12346@terpmail.umd.edu
 */
public class JdbcInstructorDAO implements InstructorDAO {

	@Override
	public void insert(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User findByUserID(int userID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isLegalUser(String username, String password) {
		// TODO Auto-generated method stub
		return false;
	}

}
