package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.dao.HospitalDAO;
import com.dao.HospitalDAOImp;

/**
 * Servlet implementation class BookAppointmentServlet
 */
@WebServlet("/bookAppointment")
public class BookAppointmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String StatusMsg="";
		if(session.getAttribute("username")==null) {
			StatusMsg="Please login before Booking your Appointment";
			session.setAttribute("StatusMsg", StatusMsg);
			response.sendRedirect("login");
		}else {
			String username=(String)session.getAttribute("username");
			int doctorId= Integer.parseInt(request.getParameter("doctorId"));
	         HospitalDAO hospitalDAO=new HospitalDAOImp();
	         
			StatusMsg=hospitalDAO.bookAppointment(username , doctorId);
			session.setAttribute("StatusMsg", StatusMsg);
			response.sendRedirect("related_doctors");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
