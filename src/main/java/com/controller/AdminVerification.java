package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.dao.AdminDAOImp;
import com.dao.OtpDao;
import com.dao.OtpDao.Otp;
import com.helper.EmailService;


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
		String adminName=(String)request.getParameter("adminName");
		String password=(String)request.getParameter("password");
		String email=(String)request.getParameter("email");
		
		
		AdminDAOImp adminDAOImp=new  AdminDAOImp();
		String status = adminDAOImp.varifyAdmin(adminName,password,email);
		
		if(status.equals("valied")) {
			
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
				
				    OtpDao.saveOtp(email, adminName, otp, System.currentTimeMillis());
				
				    response.setContentType("text/plain");
				    response.getWriter().print("send");
				}
				else {
				response.getWriter().print("Failed to send OTP ! please try again.");
				}
			return;			
		}else {
			response.getWriter().print("Invalied Cridentials");
		}
		
	}

}
