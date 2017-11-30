package com.umd.ezcomm.model.dao.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
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
	public List<Course> courseEnrolled(String userID) {
		
		String SQL = "SELECT CourseID, Name FROM Courses INNER JOIN CourseList ON Courses.ID = "
				+ "CourseList.CourseID WHERE UID = '" + userID + "';";
		
		List<Course> course = template.query(SQL, new RowMapper<Course>() {
			@Override
			public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
				Course c = new Course();
				
				c.setID(rs.getString("CourseID"));
				c.setName(rs.getString("Name"));
				
				return c;
			}
		});
		
		return course;
	}

	@Override
	public int getMessageNumber(String userID) {
		String query = "SELECT COUNT(*) FROM CourseList WHERE UID = \"" + userID + "\";";
		return template.queryForObject(query, Integer.class);
	}

	@Override
	public List<Message> messageReceived(String userID) {
		
		String SQL = "SELECT M.SenderID, M.Content, U.Name, M.Time FROM Messages M " + 
				"INNER JOIN User U ON M.SenderID = U.UID " + 
				"WHERE M.ReceiverID = '" + userID + "';";
		
		List<Message> message = template.query(SQL, new RowMapper<Message>() {
			@Override
			public Message mapRow(ResultSet rs, int rowNum) throws SQLException {
				Message m = new Message();
				
				m.setMessageID(rs.getInt("SenderID"));
				m.setContent(rs.getString("Content"));
				m.setSenderName(rs.getString("Name"));
				m.setReceivedDate(rs.getDate("Time"));
				
				return m;
			}
		});
		
		return message;
	}

	@Override
	public boolean isStudent(String uID) {
		String SQL = "SELECT COUNT(*) FROM Student WHERE UID = " + uID + ";";
		
		Integer cnt = template.queryForObject(SQL, Integer.class);

		return cnt != null && cnt > 0;
	}
}
