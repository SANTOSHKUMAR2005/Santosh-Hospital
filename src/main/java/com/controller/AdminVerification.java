package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.dao.AdminDAOImp;


@WebServlet("/admin_verification")
public class AdminVerification extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String password=(String)request.getParameter("pass");
//		System.out.println(password);
		
		AdminDAOImp adminDAOImp=new  AdminDAOImp();
		
		if(adminDAOImp.varifyAdmin(password)) {
			request.getRequestDispatcher("/WEB-INF/view/AdminPage.jsp").forward(request, response);
		}else {
			request.setAttribute("error", "*invalid password");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
		
	}

}
