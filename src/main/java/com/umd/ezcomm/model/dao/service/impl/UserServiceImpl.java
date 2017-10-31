package com.umd.ezcomm.model.dao.service.impl;

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
	
//	@Transactional
//    public long getNum(){
//        return template.queryForLong("SELECT COUNT(*) FROM User");
//    }
	
	@Override
    @Transactional
	public boolean userAuth(String uname, String psd) {
		String SQL = "SELECT COUNT(*) FROM User WHERE Name = \"" + uname + "\" And Password = \"" + psd + "\";";
		
		Integer cnt = template.queryForObject(SQL, Integer.class);

		return cnt != null && cnt > 0;
	}

	@Override
	@Transactional
	public boolean updatePassword(String n, String pwd) {
		String SQL = "UPDATE User SET Password = \"" + pwd + "\" WHERE Name = \"" + n + "\";";
		
		int row = template.update(SQL);
		
		return row == 1 ? true : false;
	}

	@Override
	@Transactional
	public boolean updateEmail(String n, String email) {
		String SQL = "UPDATE User SET Email = \"" + email + "\" WHERE Name = \"" + n + "\";";

		int row = template.update(SQL);

		return row == 1 ? true : false;
	}

	@Override
	@Transactional
	public boolean updateStatus(String n, String status) {
		String SQL = "UPDATE User SET jobStatus = \"" + status + "\" WHERE Name = \"" + n + "\";";
		
		int row = template.update(SQL);
		
		return row == 1 ? true : false;
	}

	@Override
	@Transactional
	public String getUID(String name) {
		String SQL = "SELECT UID FROM User WHERE Name = \"" + name + "\";";
		
		String ID = template.queryForObject(SQL, String.class);
		return ID;
	}
}
