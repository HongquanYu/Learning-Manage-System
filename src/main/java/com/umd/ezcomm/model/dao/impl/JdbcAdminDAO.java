package com.umd.ezcomm.model.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import com.umd.ezcomm.model.Admin;
import com.umd.ezcomm.model.User;
import com.umd.ezcomm.model.dao.AdminDAO;

/** @author: Hongquan Yu
 *  @date: Oct 10, 2017
 *
 *  @From: University of Maryland
 *  @Email: hyu12346@terpmail.umd.edu
 */
public class JdbcAdminDAO implements AdminDAO{

	private JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}


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
	public void insert(Admin user) {
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
	public int getGPAbyName(String name) {
		// TODO Auto-generated method stub
		return 0;
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
