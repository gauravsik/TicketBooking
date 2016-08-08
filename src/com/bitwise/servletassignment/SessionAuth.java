package com.bitwise.servletassignment;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//import javax.servlet.annotation.WebFilter;

//@WebFilter("/SessionAuth")
public class SessionAuth implements Filter {

	public SessionAuth() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession(false);
		PrintWriter out = res.getWriter();
		res.setContentType("text/html");
		System.out.println(req.getRequestURI());
		System.out.println("is valid user " + isValidUser(req));

		if (isLoginRequest(req)) {
			if (isExistingSession(req)) {
				out.print("<center>Allready logged in</center>");
			}
		}

		else if (isLogoutRequest(req)) {
			System.out.println("Session Invalidated");
			if (isExistingSession(req)) {
				req.getSession(false).invalidate();
				out.print("<center><font colo=red><h3>Sucessfully Logged Out</h3></center>");
				req.getRequestDispatcher("desk.html").include(req, res);
			} else {
				redirect(req, res, out);
				return;
			}
		} else if (req.getRequestURI().equals("/OnlineTicketBooking/DisplayServlet")) {
			if (!isExistingSession(req)) {
				redirect(req, res, out);
				return;
			}
		} else if (req.getRequestURI().equals("/OnlineTicketBooking/addmovie.jsp")) {
			if (!isExistingSession(req)) {
				redirect(req, res, out);
				return;
			}
		} else if (req.getRequestURI().equals("/OnlineTicketBooking/displayhistory.jsp")) {
			if (!isExistingSession(req)) {
				redirect(req, res, out);
				return;
			}
		} else if (req.getRequestURI().equals("/OnlineTicketBooking/moviebooking.jsp")) {
			if (!isExistingSession(req)) {
				redirect(req, res, out);
				return;
			}
		}

		chain.doFilter(req, res);

	}

	private void redirect(HttpServletRequest req, HttpServletResponse res, PrintWriter out)
			throws ServletException, IOException {
		out.print("<center><font colo=red><h3>Please Login first</h3></center>");
		req.getRequestDispatcher("loginform.html").include(req, res);
	}

	private boolean isLoginRequest(HttpServletRequest req) {
		return req.getRequestURI().equals("/OnlineTicketBooking/LoginServlet");
	}

	private boolean isLogoutRequest(HttpServletRequest req) {
		return req.getRequestURI().equals("/OnlineTicketBooking/LogoutServlet");
	}

	private boolean isValidUser(HttpServletRequest req) {
		if (req.getSession(false) != null)
			return req.getSession(false).getAttribute("username") != null;
		return false;
	}

	private boolean isNotAValidUser(HttpServletRequest req) {
		if (req.getSession(false) != null)
			return req.getSession(false).getAttribute("username") == null;
		return false;
	}

	private boolean isExistingSession(HttpServletRequest req) {
		return req.getSession(false) != null;
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}
}
