package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.dao.AdminDAOImp;


@WebServlet("/admin_verification")
public class AdminVerification extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String password=(String)request.getParameter("pass");
		AdminDAOImp adminDAOImp=new  AdminDAOImp();
		String username = adminDAOImp.varifyAdmin(password);
		if(password!=null && username!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("admin","hello Mr. "+username);
			//setting inactive duration for one day
			session.setMaxInactiveInterval(60*24*60);
			//get request to AdminDashbord Servlet
			response.sendRedirect("AdminDashbord");
		}else {
			request.setAttribute("error", "*invalid password");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
		
	}

}
