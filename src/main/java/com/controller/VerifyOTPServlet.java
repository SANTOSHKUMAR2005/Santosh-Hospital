package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.dao.OtpDao;
import com.dao.OtpDao.Otp;


@WebServlet("/verifyOTP")
public class VerifyOTPServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		Otp otpObj = OtpDao.getOtpByEmail(email);
		if (otpObj != null) {

			long OtpgeneratedTime = otpObj.generatedTime;

			long currentTime = System.currentTimeMillis();
			if ((currentTime - OtpgeneratedTime) > 300000) {
				OtpDao.deleteOtp(email);
				response.getWriter().print("OTP expired");
				return;
			}
			
            String userOTP=request.getParameter("otp");
			if(!userOTP.equals(otpObj.otp)) {
				response.getWriter().print("Invalied OTP");
				return;
			}
			
			 OtpDao.deleteOtp(email);
				
				// checking for admin
				String admin = request.getParameter("adminName");
				if (admin != null) {
					HttpSession session = request.getSession();
					session.setAttribute("admin", admin);
					session.setMaxInactiveInterval(60 * 24 * 60);
				}

				response.setContentType("text/plain");
				response.getWriter().print("verified");
			

		} else {
			response.getWriter().print("Illegal Action ! This can couse trouble for you.");
		}
	}
}
