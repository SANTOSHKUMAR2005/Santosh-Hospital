package com.helper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Random;

import com.sendgrid.helpers.mail.objects.Email;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.*;
public class EmailService {

	public EmailService() {
		// TODO Auto-generated constructor stub
	}
	
	public static String generateOTP() {
		Random random = new Random();
		int OTP = random.nextInt(100000, 999999);
		return OTP + "";
	}

	  public static boolean sendOtp(String recipientEmail ,String OTP) {


		  SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
		  Email from =new Email(System.getenv("hospital_email"));

		  
	    String subject = "OTP for Sign-UP at Santosh-Hospital";
	    Email to = new Email(recipientEmail);
	    String msg="Hello,  "
	    		+ "Your one-time password (OTP) : [ "+OTP+" ] "
	    		+ ""
	    		+ "This code is valid for the next 5 minutes. ";
	    
	    Content content = new Content("text/plain", msg);
	    
	    Mail mail = new Mail(from, subject, to, content);
	    
	    boolean status=false;
	    Request request = new Request();
	    try {
	      request.setMethod(Method.POST);
	      request.setEndpoint("mail/send");
	      request.setBody(mail.build());
	      Response response = sg.api(request);
          if(response.getStatusCode()==202 ||response.getStatusCode()==200)
	        status=true;
	    } catch (IOException ex) {
	    	ex.printStackTrace();
	    }
	    
	    return status;
		
	  }
}
