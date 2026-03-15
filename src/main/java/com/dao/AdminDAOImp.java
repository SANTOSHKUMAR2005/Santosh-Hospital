package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.dto.AdminDTO;
import com.dto.DoctorDTO;

public class AdminDAOImp implements AdminDAO{
	@Override
	public void createAdminTable() {
		String query="create table if not exists Admin( "
				+ "AdminName varchar(50) not null unique, "
				+ "pass varchar(50) not null, "
				+ "phone_number varchar(15)"
				+ ");";
		Connection con=Connectionfactory.getConnection();
		Statement statement=null;
		try {
			   statement=con.createStatement();
			   statement.executeUpdate(query);
			 
			
		} catch (Exception e) {

			e.printStackTrace();
		}
		Connectionfactory.close(statement);
		Connectionfactory.close(con);
	}
	
	@Override
	public String addAdmin(AdminDTO admindto) {
		Connection con=Connectionfactory.getConnection();
		PreparedStatement ps=null;
		String statusMsg=null;
		String query="insert into Admin "
				+ "(AdminName, pass, phone_number) value(?, ?, ?)";
		try {
			ps=con.prepareStatement(query);
			ps.setString(1, admindto.getName());
			ps.setString(2, admindto.getPass());
			ps.setString(3, admindto.getPhone());
			
			int a=ps.executeUpdate();
			statusMsg=(a>0)?"admin added":"admin addition failed";
		} catch (Exception e) {
			statusMsg=e.getMessage();
			e.printStackTrace();
		}
		finally {
			Connectionfactory.close(ps);
			Connectionfactory.close(con);
		}
		return statusMsg;
	}	

	@Override
	public String varifyAdmin(String password) {
		  
		String query="select AdminName from Admin where pass=? ;";
		
		Connection con=Connectionfactory.getConnection();
		PreparedStatement ps=null;
		ResultSet resultSet=null;
		try {
			ps=con.prepareStatement(query);
			ps.setString(1, password);
		    resultSet = ps.executeQuery();
			
			if(resultSet.next()) {
				return resultSet.getString("AdminName");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
		Connectionfactory.close(resultSet);
		Connectionfactory.close(ps);
		Connectionfactory.close(con);
		}
		return null;
	}
	
	
	@Override
	public String changeName(String newName) {
		
		return null;
	}

	
	@Override
	public  String changePassword(String newPass) {
		String statusMsg=null;
		Connection con = Connectionfactory.getConnection();
		PreparedStatement ps=null;
		String query="update Admin set pass=?";
		
		try {
			ps=con.prepareStatement(query);
			ps.setString(1, newPass);
			int a=ps.executeUpdate();
			statusMsg=(a>0)?"pass changed":"password not changed";
		} catch (SQLException e) {
			statusMsg=e.getMessage();
			e.printStackTrace();
		}finally {
			Connectionfactory.close(ps);
			Connectionfactory.close(con);
		}
		return statusMsg;
	}

	
	
}
