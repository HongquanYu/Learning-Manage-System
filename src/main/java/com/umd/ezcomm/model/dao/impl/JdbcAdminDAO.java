package com.umd.ezcomm.model.dao.impl;

import com.umd.ezcomm.model.User;
import com.umd.ezcomm.model.dao.AdminDAO;

/** @author: Hongquan Yu
 *  @date: Oct 10, 2017
 *
 *  @From: University of Maryland
 *  @Email: hyu12346@terpmail.umd.edu
 */
public class JdbcAdminDAO implements AdminDAO{

	/* (non-Javadoc)
	 * @see com.umd.ezcomm.model.dao.AdminDAO#insert(com.umd.ezcomm.model.User)
	 */
	@Override
	public void insert(User user) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.umd.ezcomm.model.dao.AdminDAO#findByUserID(int)
	 */
	@Override
	public User findByUserID(int userID) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.umd.ezcomm.model.dao.AdminDAO#isLegalUser(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean isLegalUser(String username, String password) {
		// TODO Auto-generated method stub
		return false;
	}

}
