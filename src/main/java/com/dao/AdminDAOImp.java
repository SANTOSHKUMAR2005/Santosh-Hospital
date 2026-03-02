package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AdminDAOImp implements AdminDAO{
	@Override
	public void createAdminTable() {
		String query="create table if not exists Admin( "
				+ "Adminname varchar(50) not null unique, "
				+ "pass varchar(50) not null, "
				+ "phone_number varchar(15)"
				+ ");";
		Connection con=Connectionfactory.getConnection();
		Statement statement=null;
		try {
			   statement=con.createStatement();
			   statement.executeUpdate(query);
			   System.out.println("Admin table created.");
			
		} catch (Exception e) {
			System.out.println("Admin table creation failed.");
			e.printStackTrace();
		}
		Connectionfactory.close(statement);
		Connectionfactory.close(con);
	}

	@Override
	public boolean varifyAdmin(String password) {
		  
		String query="select pass from admin;";
		
		Connection con=Connectionfactory.getConnection();
		Statement statement=null;
		ResultSet resultSet=null;
		boolean matched=false;
		try {
			 statement=con.createStatement();
			 resultSet = statement.executeQuery(query);
			 String pass="";
			 
			 if(resultSet.next()) {
				 
				 pass=resultSet.getString("pass");
				 System.out.println(pass);
			 }
			 else {
				 System.out.println("no any password");
			 }
			 
			 if(pass.equals(password)) matched=true;
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
		Connectionfactory.close(resultSet);
		Connectionfactory.close(statement);
		Connectionfactory.close(con);
		return matched;
		}
	}
	
	@Override
	public void setAdminPassword() {
	
		
	}

	@Override
	public void setAdminName() {
		
		
	}

	@Override
	public void changeName() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changePassword() {
		// TODO Auto-generated method stub
		
	}

	
	
}
