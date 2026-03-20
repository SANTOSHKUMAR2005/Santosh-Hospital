package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;


import com.dao.HospitalDAO;
import com.dao.HospitalDAOImp;
import com.dao.OtpDao;
import com.dao.OtpDao.Otp;
import com.helper.EmailService;

@WebServlet("/sendOTPServlet")
public class SendOTPServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;



	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String Username = request.getParameter("username");
		String email = request.getParameter("email");
		HospitalDAO hospitalDAO = new HospitalDAOImp();
		
		if(hospitalDAO.emailAvailbility(email) !=null) {
			response.getWriter().print("account with this email already exist.");
			return;
		}
	   
		if (hospitalDAO.usernameAvailbility(Username) != null) {
			response.getWriter().print("username not availble plese try diffent username");
			return;
		}

		
		Otp otpObj = OtpDao.getOtpByEmail(email);
		if(otpObj!=null){
			long generatedTime = otpObj.generatedTime;
			long diff=System.currentTimeMillis()-generatedTime;
			if(diff<300000) {
				response.getWriter().print("sended");
				return;
			}else {
				OtpDao.deleteOtp(email);
			}	
		}

		    String otp = EmailService.generateOTP();
		
			if(EmailService.sendOtp(email, otp)) {
			
			    OtpDao.saveOtp(email, Username, otp, System.currentTimeMillis());
			
			    response.setContentType("text/plain");
			    response.getWriter().print("send");
			}
			else {
			response.getWriter().print("Failed to send OTP ! please try again.");
			}
		return;
	}


}
