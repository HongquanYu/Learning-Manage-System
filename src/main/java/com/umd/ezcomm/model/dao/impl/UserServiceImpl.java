package com.umd.ezcomm.model.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;
import com.umd.ezcomm.model.dao.service.UserService;

/** @author: Hongquan Yu
 *  @date: Oct 10, 2017
 *
 *  @From: University of Maryland
 *  @Email: hyu12346@terpmail.umd.edu
 */

public class UserServiceImpl implements UserService {
	
	private JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	@Transactional
    public long getNum(){
        return template.queryForLong("SELECT COUNT(*) FROM User");
    }
	
    @Transactional
	public boolean userAuth(String uname, String psd) {
		String SQL = "SELECT COUNT(*) FROM User WHERE Name = \"" + uname + "\" And Password = \"" + psd + "\";";
		
		Integer cnt = template.queryForObject(SQL, Integer.class);

		return cnt != null && cnt > 0;
	}

	@Override
	public boolean updatePassword(String pwd) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateEmail(String email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateStatus(String status) {
		// TODO Auto-generated method stub
		return false;
	}
}
