package com.umd.ezcomm.model.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;
import com.umd.ezcomm.model.User;
import com.umd.ezcomm.model.dao.UserDAO;

/** @author: Hongquan Yu
 *  @date: Oct 9, 2017
 *
 *  @From: University of Maryland
 *  @Email: hyu12346@terpmail.umd.edu
 */

public class JdbcUserDAO implements UserDAO {

	private JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	@Override
	public void insert(User user) {
		String sql = "INSERT INTO student " + "(id, name, age) VALUES (?, ?, ?)";
		
	}

	@Override
	public User findByUserID(int userID) {
		String sql = "SELECT * FROM student WHERE id = ?";
		return null;
	}


	@Override
    @Transactional
    public boolean userAuth(String uname, String psd){
    		String SQL = "SELECT COUNT(*) FROM EZComm.student WHERE username = \"" + uname + 
    					"\" And password = \"" + psd + "\";";
    		Integer cnt = template.queryForObject(SQL, Integer.class);
    	
    		return cnt != null && cnt > 0;
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

