package com.dao;

import java.sql.*;

public class OtpDao {
    
	public static class Otp {
	     public String email;
	    public String username;
	     public String otp;
	    public long generatedTime;
	}

    public OtpDao() {
    }
    
    public static void creatOtpVerificationTable() {
    	String query="CREATE TABLE if not exists otp_verification ( "
                +"email VARCHAR(255) PRIMARY KEY , "
    		    +"username VARCHAR(100) not null , "
    		    +"otp VARCHAR(10) not null , "
    		    +"generated_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP "
    		+");";
    	Connection con=Connectionfactory.getConnection();
    	Statement s=null;
    	try {
			 s=con.createStatement();
			s.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Connectionfactory.close(s);
			Connectionfactory.close(con);
		}
    }

  
    public static boolean saveOtp(String email, String username, String otp, long time) {
        boolean status = false;
        Connection conn=Connectionfactory.getConnection();
        PreparedStatement ps=null;
        try {
            String sql = "INSERT INTO otp_verification (email, username, otp, generated_time) "
                       + "VALUES (?, ?, ?, ?) ;";

             ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, username);
            ps.setString(3, otp);
            ps.setTimestamp(4, new java.sql.Timestamp(time));
            
            int i = ps.executeUpdate();
            status = i > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
			Connectionfactory.close(ps);
			Connectionfactory.close(conn);
		}

        return status;
    }

  
    public static Otp getOtpByEmail(String email) {
        Otp otpObj = null;
        Connection conn=Connectionfactory.getConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            String sql = "SELECT * FROM otp_verification WHERE email=?";
             ps = conn.prepareStatement(sql);
            ps.setString(1, email);

            rs = ps.executeQuery();

            if (rs.next()) {
                otpObj = new Otp();
                otpObj.email=(rs.getString("email"));
                otpObj.username=(rs.getString("username"));
                otpObj.otp=(rs.getString("otp"));
                otpObj.generatedTime=(rs.getTimestamp("generated_time").getTime());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
        	Connectionfactory.close(rs);
        	Connectionfactory.close(ps);
			Connectionfactory.close(conn);
		}

        return otpObj;
    }

  
    public static boolean deleteOtp(String email) {
        boolean status = false;
        Connection conn=Connectionfactory.getConnection();
        PreparedStatement ps=null;
        try {
            String sql = "DELETE FROM otp_verification WHERE email=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, email);

            int i = ps.executeUpdate();
            status = i > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
			Connectionfactory.close(ps);
			Connectionfactory.close(conn);
		}

        return status;
    }

}