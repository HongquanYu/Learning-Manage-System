package com.umd.ezcomm.model.dao.service;

import java.util.List;
import com.umd.ezcomm.model.domain.Course;
import com.umd.ezcomm.model.domain.Message;

/** @author: Hongquan Yu
 *  @date: Oct 10, 2017
 *
 *  @From: University of Maryland
 *  @Email: hyu12346@terpmail.umd.edu
 */
public interface UserService {
	
	public String getUID(String userEmail);

	public boolean userAuth(String email, String pasd);

	public boolean updatePassword(String n, String p);

	public boolean updateEmail(String n, String email);

	public boolean updateStatus(String n, String status);
	
	public int getCourseNumber(String userID);
	
	public int getMessageNumber(String userID);
	
	public List<Course> courseEnrolled(String id);
	
	public List<Message> messageReceived(String userID);
	
	
}
