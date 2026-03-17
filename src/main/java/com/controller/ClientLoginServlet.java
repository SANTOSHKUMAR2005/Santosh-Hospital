package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


import com.dao.HospitalDAO;
import com.dao.HospitalDAOImp;

/**
 * Servlet implementation class ClientLoginServlet
 */
@WebServlet("/login")
public class ClientLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username").trim();
		String password = request.getParameter("password").trim();

		HospitalDAO hospitalDAO = new HospitalDAOImp();
		String verifyStatus = hospitalDAO.verifyClient(username, password);
		HttpSession session = request.getSession();

		if (verifyStatus != null && verifyStatus.equals("verified")) {
			session.setAttribute("username", username);
			response.sendRedirect("home");
			

		} else {
			session.setAttribute("StatusMsg", verifyStatus);
			response.sendRedirect("login");
		}

	}

}
