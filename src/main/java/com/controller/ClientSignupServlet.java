package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;

import com.dao.HospitalDAO;
import com.dao.HospitalDAOImp;
import com.dto.ClientDTO;

/**
 * Servlet implementation class ClientSignupServlet
 */
@WebServlet("/Signup")
public class ClientSignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/signup.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		
		String username=request.getParameter("username");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		ClientDTO client=new ClientDTO(username , password , email);
		
		HospitalDAO hospitalDao=new HospitalDAOImp();
		String StatusMsg=hospitalDao.addClient(client);
		
		response.getWriter().print(StatusMsg);
		
		
	}

}
