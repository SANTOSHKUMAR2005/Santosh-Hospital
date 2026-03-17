package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.dao.AdminDAOImp;


@WebServlet(
		   urlPatterns = {"/admin_verification", "/adminLogin"}
		)
public class AdminVerification extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/view/adminLogin.jsp").forward(req, resp);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=(String)request.getParameter("username");
		String password=(String)request.getParameter("password");
		String phone=(String)request.getParameter("phone");
		
		if(phone.charAt(0)=='+') {
			phone=(phone.substring(3,phone.length())).trim();
		}
		
		AdminDAOImp adminDAOImp=new  AdminDAOImp();
		String status = adminDAOImp.varifyAdmin(username,password,phone);
		
		HttpSession session = request.getSession();
		
		if(status.equals("valied")) {
			session.setAttribute("admin",username);
			//setting inactive duration for one day
			session.setMaxInactiveInterval(60*24*60);
			
			//sending OTP on given number
			String otp=SendOTPServlet.generateOTP();
			
		//	boolean OTPStatus= SendOTP(phone,otp);
			boolean OTPStatus = true;
			if (OTPStatus) {
				session.setAttribute("otp", otp);
				session.setAttribute("otpTime", System.currentTimeMillis());
				System.out.println(otp);
				response.setContentType("text/plain");
				response.getWriter().print("send");
			} else {
				response.getWriter().print("failed to send OTP. Please try Again");
			}
			
		}else {
			response.getWriter().print("Invalied Cridentials");
		}
		
	}

}
