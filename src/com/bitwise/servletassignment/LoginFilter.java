package com.bitwise.servletassignment;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

//@WebFilter("/LoginFilter")
public class LoginFilter implements Filter {

	public LoginFilter() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		response.setContentType("text/html");
		System.out.println("login filter started");
		//HttpServletRequest req = (HttpServletRequest) request;
		//HttpServletResponse res = (HttpServletResponse) response;
		
		String username = null;
		String password = null;
		username = request.getParameter("username");
		password = request.getParameter("password");
		User user = new User(username , password);
		PrintWriter pw = response.getWriter();

		System.out.println("username : " + username + " password : " + password);
		RegisteredUsers ru = new RegisteredUsers();
	
		if (username != null) {
			if (ru.getUsersData().contains(user)) {
				System.out.println("valid credentials");
				chain.doFilter(request, response);
			} else {
				pw.write("<center><font color=red><h1>Invalid Credentials!</h1></font><center>");
				System.out.println("invalid credentials (1 in else)");
				request.getRequestDispatcher("loginform.html").include(request, response);
			}
		} else {
			pw.write("<center><font color=red><h1>Invalid Credentials</h1></font><center>");
			System.out.println("invalid credentials (in else)");
			request.getRequestDispatcher("loginform.html").include(request, response);
		}
		pw.close();
		pw.flush();
		System.out.println("loginfilter ended");
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
