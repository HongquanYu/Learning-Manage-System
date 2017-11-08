package com.umd.ezcomm.model.dao.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.umd.ezcomm.model.dao.service.UserService;
import com.umd.ezcomm.model.domain.Course;
import com.umd.ezcomm.model.domain.Message;

/** @author: Hongquan Yu
 *  @date: Oct 10, 2017
 *
 *  @From: University of Maryland
 *  @Email: hyu12346@terpmail.umd.edu
 */

@Service
public class UserServiceImpl implements UserService {
	
	private JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	@Override
    @Transactional
	public boolean userAuth(String email, String pasd) {
		String SQL = "SELECT COUNT(*) FROM User WHERE Email = \"" + email + "\" And Password = \"" + pasd + "\";";
		
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
	public String getUID(String userEmail) {
		String SQL = "SELECT UID FROM User WHERE Email = \"" + userEmail + "\";";
		
		return template.queryForObject(SQL, String.class);
	}

	@Override
	public int getCourseNumber(String userID) {
		String query = "SELECT COUNT(*) FROM CourseList WHERE UID = \"" + userID + "\";";
		return template.queryForObject(query, Integer.class);
	}
	
	@Override
	public List<Course> courseEnrolled(String id) {
		List<Course> res = new LinkedList<Course>();
		
		String SQL = "SELECT * FROM User WHERE UID = :uid";
		Map<String, String> paraMaps = new HashMap<>();
		paraMaps.put("uid", id);
		
		/*NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(null);
		
		res = template.query(SQL, paraMaps,);*/

		return res;
	}

	@Override
	public int getMessageNumber(String userID) {
		String query = "SELECT COUNT(*) FROM CourseList WHERE UID = \"" + userID + "\";";
		return template.queryForObject(query, Integer.class);
	}

	/* (non-Javadoc)
	 * @see com.umd.ezcomm.model.dao.service.UserService#messageReceived(java.lang.String)
	 */
	@Override
	public List<Message> messageReceived(String userID) {
		// TODO Auto-generated method stub
		return null;
	}
}
