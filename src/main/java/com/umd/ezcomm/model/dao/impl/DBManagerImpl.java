package com.umd.ezcomm.model.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;
import com.umd.ezcomm.model.dao.DBManager;

/** @author: Hongquan Yu
 *  @date: Oct 10, 2017
 *
 *  @From: University of Maryland
 *  @Email: hyu12346@terpmail.umd.edu
 */

public class DBManagerImpl implements DBManager {
	
	private JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	@Transactional
    public long getNum(){
        return template.queryForLong("SELECT COUNT(*) FROM student");
    }
	
    @Transactional
    public boolean userAuth(String uname, String psd){
    		String SQL = "SELECT COUNT(*) FROM EZComm.student WHERE username = \"" + uname + 
    					"\" And password = \"" + psd + "\";";
    		Integer cnt = template.queryForObject(SQL, Integer.class);
    	
    		return cnt != null && cnt > 0;
    }

    @Transactional
    public int setSal(Double sal){
        return template.update("UPDATE EMP T SET T.SAL = " + sal + " WHERE T.EMPNO = 7369");
    }
}
