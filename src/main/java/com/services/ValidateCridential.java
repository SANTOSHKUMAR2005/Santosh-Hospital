package com.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dao.Connectionfactory;
import com.dto.DoctorDTO;

public class ValidateCridential {
     public static String ValidateDoctorDetails(DoctorDTO dto) {
    	 
     //validate name
    	 String name=dto.getDoctor_name().trim();
    	 if(name.length()<4) {
    		 return "Enter valied name and please Use 'Dr.' before the name";
    	 }else if(!(name.substring(0, 2).toUpperCase().equals("DR"))) {
    		 return "please Use Dr. before the name";
    	 }
    	 
    //validating specialization
    	 if(dto.getSpecialization().equals("select")) {
    		 return "pelese select specialization";
    	 }
    	 
    //validating qualification
    	 if(dto.getQualifications()==null) {
    		 return "please enter qualification";
    	 }
    	 
    //validation license no;
    	 String sql="select license_no from doctors "
    	 		+ "where license_no=? ;";
    	 boolean flage=true;
    	 Connection con=Connectionfactory.getConnection();
    	 PreparedStatement ps=null;
    	 try {
			ps=con.prepareStatement(sql);
			ps.setString(1, dto.getLicense_no());
			
			ResultSet rs = ps.executeQuery();
			if(rs.getRow()!=0) {
				flage=false;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
    	 finally {
			Connectionfactory.close(ps);
			Connectionfactory.close(con);
		}
    	 if(!flage) {
    		 return "the doctor with given license no is alrady exist";
    	 }
    	    //manage other details of license no
    	 
    	 
   //validate phone number
    	 int n=dto.getPhone_no().length();
    	 if(n<10) {
    		 return "please enter a valide phone no. ";
    	 }
    	 String s="";
    	 if(dto.getPhone_no().charAt(0)=='+') {
    		 s=dto.getPhone_no().substring(3,n);
    	 }else {
    		 s=dto.getPhone_no();
    	 }
    	 s=s.trim();
    	 n=s.length();
    	 if(n!=10) {
    		 return "please enter a valide phone no. ";
    	 }
    	
    	 for(char ch : s.toCharArray()) {
    		 int a=(int)ch;
    		 if(a<48 || a>57) {
    			 return "please enter a valide phone no. ";
    		 }
    	 }
    	 
    	 if(dto.getPhone_no().charAt(0)=='+') {
    		 dto.setPhone_no(dto.getPhone_no().substring(0,3)+' '+s);
    	 }else {
    		 dto.setPhone_no(s);
    	 }
    	 
    //	 
    	 
    	 return "valide";
     }
}
