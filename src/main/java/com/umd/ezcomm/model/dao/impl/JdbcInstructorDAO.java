package com.umd.ezcomm.model.dao.impl;

import com.umd.ezcomm.model.Instructor;
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
	public User findByUserID(int userID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean userAuth(String uname, String psd) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void insert(Instructor user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User findByUserName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findByTel(int tel) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User getProfile(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getGPAbyUserID(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean updateUserName(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateUserPassword(String psd) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateUserEmail(String email) {
		// TODO Auto-generated method stub
		return false;
	}

}
