package com.dao;


import java.sql.Connection;
import java.sql.SQLException;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class Connectionfactory {
	static HikariDataSource dataSource;

	public static void init(String driver, String url, String username,String password) {
		  
		try {
			Class.forName(driver);
			HikariConfig config=new HikariConfig();
			
			config.setJdbcUrl(url);
			config.setUsername(username);
			config.setPassword(password);
			
			config.setMinimumIdle(10);
			config.setMaximumPoolSize(500);
			dataSource=new HikariDataSource(config);
			
		} catch (Exception e) {
		
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		Connection con=null;
		try {
			if(dataSource!=null) {
			con= dataSource.getConnection();
			}
		} catch (SQLException e) {
			
		}
		return con;
	}
	
	public static void closeDataSource() {
		if(dataSource!=null) {
			dataSource.close();
		}
	}
	
	public static void close(AutoCloseable resource) {
		try {
			if(resource!=null)
			resource.close();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
}
