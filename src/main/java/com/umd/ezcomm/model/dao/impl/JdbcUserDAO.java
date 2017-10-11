package com.umd.ezcomm.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.umd.ezcomm.model.User;
import com.umd.ezcomm.model.dao.UserDAO;

/** @author: Hongquan Yu
 *  @date: Oct 9, 2017
 *
 *  @From: University of Maryland
 *  @Email: hyu12346@terpmail.umd.edu
 */

public class JdbcUserDAO implements UserDAO {

	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void insert(User user) {
		String sql = "INSERT INTO student " + "(id, name, age) VALUES (?, ?, ?)";
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, user.getUserID());
			ps.setString(2, user.getName());
			ps.setInt(3, user.getAge());
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	@Override
	public User findByUserID(int userID) {
		String sql = "SELECT * FROM student WHERE id = ?";

		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userID);
			User user = null;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user = new User(rs.getInt("id"), rs.getString("name"), rs.getInt("age"));
			}
			rs.close();
			ps.close();
			return user;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	@Override
	public boolean isLegalUser(String uname, String psd) {
		String sql = "SELECT username, password FROM student "
				+ "WHERE username = ? AND password = ?";
		
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement pss = conn.prepareStatement(sql);
			pss.setString(1, uname);
			pss.setString(2, psd);
			User user = null;
			ResultSet rs = pss.executeQuery();
			if (rs.next()) {
				user = new User(rs.getString("username"), rs.getString("password"));
			}
			rs.close();
			pss.close();
			return user == null ? false : true;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}
}

