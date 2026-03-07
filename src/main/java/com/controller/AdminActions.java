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

import com.dto.AdminDTO;
import com.dto.DoctorDTO;
import com.dao.AdminDAO;
import com.dao.AdminDAOImp;
import com.dao.HospitalDAOImp;

import com.services.ValidateCridential;


@WebServlet("/Admin_actions")
@MultipartConfig(
		fileSizeThreshold = 1024*1024 //1mb
		)
public class AdminActions extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String formType=(String)request.getParameter("formType");
		HttpSession session=request.getSession(false);
		String statusMsg=null;
		
		
		
		  if(formType.equals("addDoctor")) {
			  HospitalDAOImp hospitalDAOImp=new HospitalDAOImp();
		    DoctorDTO dto=new DoctorDTO();
            dto.setDoctor_name(request.getParameter("doctorName"));
            //extracting image data
            Part part = request.getPart("photo");
            InputStream is = part.getInputStream();
            dto.setPhoto_inputStream(is);
  
            dto.setSpecialization(request.getParameter("specialization"));
            dto.setQualifications(request.getParameter("qualification"));
            dto.setLicense_no(request.getParameter("licenceNo"));
            dto.setPhone_no(request.getParameter("phoneNo"));
            dto.setCabin_no(Integer.parseInt(request.getParameter("cabinNo")));
            dto.setSalary(Integer.parseInt(request.getParameter("salary")));
            dto.setConsultation_fee(Integer.parseInt(request.getParameter("consultationFee")));
            
            String s=ValidateCridential.ValidateDoctorDetails(dto);
            
            if(s.equals("valide")) {
        	    statusMsg=hospitalDAOImp.addDoctor(dto);
        	    session.setAttribute("statusMsg",statusMsg);
            }else {
          	  session.setAttribute("statusMsg", s);
            }
		  }
		  else if(formType.equals("removeDoctor")) {
			  HospitalDAOImp hospitalDAOImp=new HospitalDAOImp();
			  int doctorId =Integer.parseInt(request.getParameter("doctorId"));
			  if(doctorId>0) {
				  statusMsg=hospitalDAOImp.deleteDoctor(doctorId);
				  session.setAttribute("statusMsg", statusMsg);
			  }else {
				  session.setAttribute("statusMsg", "please Enter the correct doctor Id.");
			  }
			  
		  }
		  else if(formType.equals("changeAdminPass")) {
			  AdminDAO adminDao=new AdminDAOImp();
			  String newPass=(String)request.getParameter("newPass");
			  statusMsg=adminDao.changePassword(newPass);
			  session.setAttribute("statusMsg", statusMsg);
		  }
		  else if(formType.equals("addAdmin")) {
			  AdminDAO adminDao=new AdminDAOImp();
			  String name= (String)request.getParameter("AdminName");
			  String pass=(String)request.getParameter("pass");
			  String phone=(String)request.getParameter("phone");
			  statusMsg=adminDao.addAdmin(new AdminDTO(name,pass,phone));
			  session.setAttribute("statusMsg", statusMsg);
		  }
          
		  session.setAttribute("formType", formType);
          response.sendRedirect("AdminDashbord"); 
	}

}
