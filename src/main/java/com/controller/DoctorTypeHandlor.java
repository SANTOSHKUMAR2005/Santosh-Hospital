package com.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import com.dao.HospitalDAOImp;
import com.dto.DocBasicInfo;
import com.dto.DoctorDTO;

@WebServlet("/related_doctors")
public class DoctorTypeHandlor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	
		String type=request.getParameter("type");
	
		if(type==null) {
			response.sendRedirect("index.html");
			 
			return;
		}
		
//		switch (type) {
//		    case "Cardiologists": {
//		    	request.setAttribute("docType" , "Cardiologists");
//		    	
//		    	break;
//		    }
//            case "Dernatologists": {
//	              request.setAttribute("docType" , "Dernatologists");
//	         
//		    	break;
//		    }
//            case "Oncologists": {
//	              request.setAttribute("docType" , "Oncologists");
//	            
//		    	break;
//		    }
//            case "Neurologists": {
//	              request.setAttribute("docType" , "Neurologists");
//	    
//		    	break;
//		    }
//            case "Endocrirologists": {
//	              request.setAttribute("docType" , "Endocrirologists");
//	            
//		    	break;
//		    }
//            case "Gastoenterologist": {
//	              request.setAttribute("docType" , "Gastoenterologist");
//	             
//		    	break;
//		    }
//            case "Ophthatnologist": {
//            	request.setAttribute("docType" , "Ophthatnologist");
//            	
//		    	break;
//		    }
//            case "Psychiatrist": {
//            	request.setAttribute("docType" , "Psychiatrist");
//            	
//		    	break;
//		    }
//            case "Pulmonologist": {
//            	request.setAttribute("docType" , "Pulmonologist");
//            	
//		    	break;
//		    }
//            case "Rheumatologist": {
//            	request.setAttribute("docType" , "Rheumatologist");
//            	
//		    	break;
//		    }
//            case "Urologist": {
//            	request.setAttribute("docType" , "Urologist");
//            	
//		    }
//		}
		
		HospitalDAOImp HDAOI=new HospitalDAOImp();
	
		ArrayList<DocBasicInfo> doctors=HDAOI.getRelatedDoctors(type);
		request.setAttribute("docType", type);
		request.setAttribute("doctors", doctors);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/view/doctorsDiscriptions.jsp");
		 dispatcher.forward(request, response);  
		}
		
}
