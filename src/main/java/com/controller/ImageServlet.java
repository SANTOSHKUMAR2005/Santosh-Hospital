package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.dao.Connectionfactory;


/**
 * Servlet implementation class Image
 */
@WebServlet("/image")
public class ImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    int id=Integer.parseInt(request.getParameter("id"));
	    Connection con=Connectionfactory.getConnection();
	    PreparedStatement ps=null;
	    String query="select photo from doctors where doctor_id=?";
	    ResultSet rs=null;
	    try {
			ps=con.prepareStatement(query);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			
			if(rs.next()){
				InputStream is=rs.getBinaryStream("photo");
				response.setContentType("image/jpeg");
				
				byte[] buffer=new byte[1024];
				int bytesRead;
				
				while((bytesRead=is.read(buffer)) !=-1) {
					response.getOutputStream().write(buffer, 0, bytesRead);
				}
			 }
		} catch (Exception e) {
		   e.printStackTrace();
		}finally {
			Connectionfactory.close(rs);
			Connectionfactory.close(ps);
			Connectionfactory.close(con);
		}
	    
	}

}



        

           