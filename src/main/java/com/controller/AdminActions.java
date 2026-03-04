package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.InputStream;

import com.dto.DoctorDTO;

import com.services.ValidateCridential;

/**
 * Servlet implementation class AddDoctor
 */
@WebServlet("/Admin_actions")
@MultipartConfig(
		//fileSizeThreshold = 1024*1024 //1mb
		)
public class AdminActions extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String formType=(String)request.getParameter("formType");
		HttpSession session=request.getSession(false);
		
		  if(formType.equals("addDoctor")) {
		    DoctorDTO dto=new DoctorDTO();
            dto.setDoctor_name(request.getParameter("doctorName"));
            //extracting image data
            Part part = request.getPart("photo");
            InputStream is = part.getInputStream();
            byte[] allBytes = is.readAllBytes();
            dto.setPhoto_bytes(allBytes);
  
            dto.setSpecialization(request.getParameter("specialization"));
            dto.setQualifications(request.getParameter("qualification"));
            dto.setLicense_no(request.getParameter("licenceNo"));
            dto.setPhone_no(request.getParameter("phoneNo"));
            dto.setCabin_no(Integer.parseInt(request.getParameter("cabinNo")));
            dto.setSalary(Integer.parseInt(request.getParameter("salary")));
            dto.setConsultation_fee(Integer.parseInt(request.getParameter("consultationFee")));
            
            String s=ValidateCridential.ValidateDoctorDetails(dto);
            
            if(s.equals("valide")) {
        	    //store the data into data base
        	    session.setAttribute("statusMsg", "positive");
            }else {
          	  session.setAttribute("statusMsg", s);
            }
		  }
		  else if(formType.equals("removeDoctor")) {
			  session.setAttribute("statusMsg", "this form is for removing form");
			  
		  }
		  else if(formType.equals("changeAdminPass")) {
			  session.setAttribute("statusMsg", "this form is for changing password");
			  
		  }
		  else if(formType.equals("changeAdmin")) {
			  session.setAttribute("statusMsg", "this form is for changing admin.");
			  
		  }
          
		  session.setAttribute("formType", formType);
          response.sendRedirect("AdminDashbord"); 
	}

}
