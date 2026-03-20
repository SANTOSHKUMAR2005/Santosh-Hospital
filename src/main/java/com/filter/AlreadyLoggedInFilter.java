package com.filter;

import java.io.IOException;
import java.net.http.HttpResponse;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter(urlPatterns = {"/adminLogin" ,"/login"})
public class AlreadyLoggedInFilter implements Filter {

	public AlreadyLoggedInFilter() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)arg0;
	    HttpServletResponse res= (HttpServletResponse)arg1;
	    
		HttpSession session = req.getSession(false);
		if(session !=null && session.getAttribute("admin")!=null) {
			res.sendRedirect(req.getContextPath()+ "/AdminDashbord");
		}
		else if(session !=null && session.getAttribute("username")!=null) {
			res.sendRedirect(req.getContextPath()+ "/home");
		}else {
			arg2.doFilter(arg0, arg1);
		}
	}

}
