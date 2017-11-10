package com.umd.ezcomm.model.dao.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
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
	
	@SuppressWarnings("unused")
	private static final Logger log = LogManager.getLogger();
	
	private JdbcTemplate template;
	private NamedParameterJdbcTemplate temp;
	
	public void setTemp(NamedParameterJdbcTemplate temp) {
		this.temp = temp;
	}
	
	@Qualifier(value="dataSource")
	private DataSource dataSource;
	
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
	public List<Course> courseEnrolled(String sid) {
		
//		NamedParameterJdbcTemplate temp = new NamedParameterJdbcTemplate(dataSource);
		
		String SQL = "SELECT CourseID, Name FROM Courses INNER JOIN CourseList ON Courses.ID = "
				+ "CourseList.CourseID WHERE UID = :sid";
		Map<String, String> paraMaps = new HashMap<>();
		paraMaps.put("sid", sid);
		
		List<Course> res = temp.query(SQL, paraMaps, new RowMapper<Course>() {
			@Override
			public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
				Course cou = new Course();
				
				cou.setID(rs.getString("ID"));
				cou.setName(rs.getString("Name"));
				
				return cou;
			}
		});
		
//		List<Course> res = (List<Course>) template.queryForObject(SQL, Course.class);
		
		return res;
	}

	@Override
	public int getMessageNumber(String userID) {
		String query = "SELECT COUNT(*) FROM CourseList WHERE UID = \"" + userID + "\";";
		return template.queryForObject(query, Integer.class);
	}

	@Override
	public List<Message> messageReceived(String userID) {
		
		return null;
	}
}
