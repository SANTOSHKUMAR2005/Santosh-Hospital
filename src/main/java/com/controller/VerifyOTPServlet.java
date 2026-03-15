package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class VerifyOTPServlet
 */
@WebServlet("/verifyOTP")
public class VerifyOTPServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		long otpTime=(Long)session.getAttribute("otpTime");
	   long currentTime = System.currentTimeMillis();
	   if((currentTime-otpTime)>150000) {
		   response.getWriter().print("OTP expired");
		   return;
	   }
		
		String originalOTP=(String)session.getAttribute("otp");
		String enteredOTP=request.getParameter("otp");
		if(originalOTP.equals(enteredOTP)) {
			
			session.removeAttribute("otp");
			session.removeAttribute("otpTime");
			
			
			response.setContentType("text/plain");
			response.getWriter().print("verified");
		}else {
			response.getWriter().print("Invalied OTP");
		}
	}

}
