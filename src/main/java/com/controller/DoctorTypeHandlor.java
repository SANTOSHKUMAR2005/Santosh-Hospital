package com.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

import com.dao.HospitalDAOImp;
import com.dto.DocBasicInfo;


@WebServlet("/related_doctors")
public class DoctorTypeHandlor extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	
		String type=request.getParameter("type");
		HttpSession session = request.getSession();
		String Stype=(String)session.getAttribute("type");
	
	if(type!=null && !type.equals(Stype)) {
		HospitalDAOImp HDAOI=new HospitalDAOImp();
	
		ArrayList<DocBasicInfo> doctors=HDAOI.getRelatedDoctors(type);
		session.setAttribute("docType", type);
		session.setAttribute("doctors", doctors);
	}
	
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/view/doctorsDiscriptions.jsp");
		 dispatcher.forward(request, response);  
		}
		
}
