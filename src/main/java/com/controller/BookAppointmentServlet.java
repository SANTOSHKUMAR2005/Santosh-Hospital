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


@WebServlet("/bookAppointment")
public class BookAppointmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


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
	        if(!hospitalDAO.hasAppointmentBooked(username, doctorId)) {
	         
			StatusMsg=hospitalDAO.bookAppointment(username , doctorId);
	        }else {
	        	StatusMsg="your appointment has been booked already.";
	        }
			session.setAttribute("StatusMsg", StatusMsg);
			response.sendRedirect("related_doctors");
		}
		
	}


}
