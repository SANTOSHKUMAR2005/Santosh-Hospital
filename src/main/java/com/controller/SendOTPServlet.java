package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;

/**
 * Servlet implementation class SendOTPServlet
 */
@WebServlet("/sendOTPServlet")
public class SendOTPServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String phone=request.getParameter("phone");
		
		String otp=generateOTP();
//		SendOTP(phone,otp);
//		
	   HttpSession session = request.getSession();
	   session.setAttribute("otp", otp);
	   session.setAttribute("otpTime", System.currentTimeMillis());
	   System.out.println(otp);
		response.setContentType("text/plain");;
		response.getWriter().print("send");	
	}
    
	private String generateOTP() {
		Random random=new Random();
		int OTP=random.nextInt(100000, 999999);
		return OTP+"";
	}
	
	private void SendOTP(String phone, int OTP) {
		
		String MyApiKey="";
		try {
			URL url = new URL("");
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("post");
			con.setRequestProperty("authorization", MyApiKey);
			con.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
			con.setDoOutput(true);
			
			String message="your OTP is "+OTP;
			String data="route=3&sender_id=SantoshHospital&message="+message+"&language=english&flash=0&numbers="+phone;
			
			OutputStream os = con.getOutputStream();
			os.write(data.getBytes());
			os.flush();
			os.close();
			System.out.println(con.getResponseCode());
			System.out.println(con.getResponseMessage());
	
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
}
