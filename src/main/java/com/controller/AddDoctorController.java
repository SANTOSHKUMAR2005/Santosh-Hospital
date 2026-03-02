package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.InputStream;

import com.dto.DoctorDTO;

import com.services.ValidateCridential;

/**
 * Servlet implementation class AddDoctor
 */
@WebServlet("/add_doctor_servlet")
@MultipartConfig(
		//fileSizeThreshold = 1024*1024 //1mb
		)
public class AddDoctorController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("hiiiii");
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
        	  request.setAttribute("msg", "inserted");
          }else {
        	  request.setAttribute("msg", s);
          }
          
          request.getRequestDispatcher("/WEB-INF/view/AdminPage.jsp").forward(request, response);;
         
	}

}
