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
				+ "photo blob not null , "
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

	
	@Override
	public void addDoctor(DoctorDTO docDTO) {
		Connection con=Connectionfactory.getConnection();
		PreparedStatement ps=null;
		String query="insert into doctors "
				+ "(doctor_name , photo , specialization, qualifications, license_no, phone_no, cabin_no, salary, consultation_fee)"
				+ "values"
				+ "(?,?,?,?,?,?,?,?,?);";
	
		try {
			ps=con.prepareStatement(query);
			ps.setString(1, docDTO.getDoctor_name());
			ps.setBytes(2, docDTO.getPhotoBytes());
			ps.setString(3, docDTO.getSpecialization());
			ps.setString(4, docDTO.getQualifications());
			ps.setString(5, docDTO.getLicense_no());
			ps.setString(6, docDTO.getPhone_no());
			ps.setInt(7, docDTO.getCabin_no());
			ps.setInt(8, docDTO.getSalary());
			ps.setInt(9, docDTO.getConsultation_fee());
			
			int a=ps.executeUpdate();
			if(a>0) {
				System.out.println("doctor data inserted.");
			}
			
		} catch (SQLException e) {
			System.out.println("doctor data not inserted.");
			e.printStackTrace();
		}
		
		Connectionfactory.close(ps);
		Connectionfactory.close(con);

	}

	@Override
	public void deleteDoctor() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addClient() {
		// TODO Auto-generated method stub
		
	}

	

}
