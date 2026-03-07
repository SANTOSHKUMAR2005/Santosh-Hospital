package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



import com.dto.DoctorDTO;

public class HospitalDAOImp implements HospitalDAO{

	@Override
	public  void createDoctorsTable() {
		String query="create table if not exists doctors ("
				+ "doctor_id int unique not null primary key auto_increment, "
				+ "doctor_name varchar(100) not null, "
				+ "photo longblob not null , "
				+ "specialization varchar(20) not null, "
				+ "qualifications varchar(200) not null, "
				+ "license_no varchar(50) not null unique, "
				+ "phone_no varchar(15) not null unique, "
				+ "cabin_no int not null, "
				+ "salary int not null, "
				+ "consultation_fee int not null"
				+ ");";
		
		Connection con=Connectionfactory.getConnection();
		Statement statement=null;
		ResultSet rs=null;
		try  {
			   
			 statement = con.createStatement();
			 int a=statement.executeUpdate(query);
			if(a>0)
			System.out.println("dotors table created.");
			
		} catch (SQLException e) {
			System.out.println("dotors table creation failed.");
			e.printStackTrace();
		}
		
		Connectionfactory.close(rs);
		Connectionfactory.close(statement);
		Connectionfactory.close(con);
		
	}

	@Override
	public void createPatientTable() {
		String query="create table if not exists patients ("
				+ "patient_id int unique not null primary key auto_increment, "
				+ "patient_name varchar(100) not null, "
				+ "phone_no varchar(15) not null, "
				+ "doctor_id int not null, "
				+ "appointment_date datetime not null"
				+ ");";
		
		Connection con=Connectionfactory.getConnection();
		Statement statement=null;
		ResultSet rs=null;
		try  {
			   
			 statement = con.createStatement();
			 int a=statement.executeUpdate(query);
			if(a>0)
			System.out.println("patients table created.");
			
		} catch (SQLException e) {
			System.out.println("patients table creation failed.");
			e.printStackTrace();
		}
		
		Connectionfactory.close(rs);
		Connectionfactory.close(statement);
		Connectionfactory.close(con);
		
		
	}

	
	@SuppressWarnings("finally")
	@Override
	public String addDoctor(DoctorDTO docDTO) {
		String statusMsg=null;
		Connection con=Connectionfactory.getConnection();
		PreparedStatement ps=null;
		String query="insert into doctors "
				+ "(doctor_name , photo , specialization, qualifications, license_no, phone_no, cabin_no, salary, consultation_fee)"
				+ "values"
				+ "(?,?,?,?,?,?,?,?,?);";
	
		try {
			ps=con.prepareStatement(query);
			ps.setString(1, docDTO.getDoctor_name());
			ps.setBlob(2, docDTO.getPhoto_inputStream());
			ps.setString(3, docDTO.getSpecialization());
			ps.setString(4, docDTO.getQualifications());
			ps.setString(5, docDTO.getLicense_no());
			ps.setString(6, docDTO.getPhone_no());
			ps.setInt(7, docDTO.getCabin_no());
			ps.setInt(8, docDTO.getSalary());
			ps.setInt(9, docDTO.getConsultation_fee());
			
			int a=ps.executeUpdate();
			
			statusMsg=(a>0)?"inserted":"doctor data not inserted.";
			
			
		} catch (SQLException e) {
			statusMsg=e.getMessage();
			e.printStackTrace();
		}finally {
			Connectionfactory.close(ps);
			Connectionfactory.close(con);
			return statusMsg;
		}
	}

	@SuppressWarnings("finally")
	@Override
	public String deleteDoctor(int doctorId) {
	    String statusMsg=null;
	    Connection con = Connectionfactory.getConnection();
	    PreparedStatement ps=null;
	    String query1="select doctor_id from doctors where doctor_id=?";
	    String query2="delete from doctors where doctor_id=?";
	    
	    try {
	    	ps=con.prepareStatement(query1);
	    	ps.setInt(1, doctorId);
	    	ResultSet rs = ps.executeQuery();
	    	if(rs.next()) {
	    		ps=con.prepareStatement(query2);
	    		ps.setInt(1, doctorId);
	    		int a=ps.executeUpdate();
	    		statusMsg=(a>0)?"deleted":"deletion failed";
	    		
	    	}else {
	    		statusMsg="doctor with provided id not exist";
	    	}
			
		} catch (Exception e) {
			statusMsg=e.getMessage();
			e.printStackTrace();
		}finally {
			Connectionfactory.close(ps);
		    Connectionfactory.close(con);
			return statusMsg;
		}
	}

	@Override
	public String addClient() {
		// TODO Auto-generated method stub
		return null;
		
	}

	

}
