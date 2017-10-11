package com.umd.ezcomm.model.dao.impl;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import com.umd.ezcomm.model.dao.DBManager;

/** @author: Hongquan Yu
 *  @date: Oct 10, 2017
 *
 *  @From: University of Maryland
 *  @Email: hyu12346@terpmail.umd.edu
 */

@Service
public class DBManagerImpl implements DBManager {
	
	private JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	@Transactional
    public long getNum(){
        return template.queryForLong("SELECT id FROM student");
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
    

	/*
	@Override
	public DataSource getConnect() {
		Properties props = new Properties();
		FileInputStream fis = null;
		MysqlDataSource mysqlDS = null;
		try {
			fis = new FileInputStream("db.properties");
			props.load(fis);
			mysqlDS = new MysqlDataSource();
			mysqlDS.setURL(props.getProperty("MYSQL_DB_URL"));
			mysqlDS.setUser(props.getProperty("MYSQL_DB_USERNAME"));
			mysqlDS.setPassword(props.getProperty("MYSQL_DB_PASSWORD"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return mysqlDS;
	}

	@Override
	public void destroy(DataSource ds) {
		destroy(ds);
	}
	
	*/
}
