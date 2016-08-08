package com.bitwise.servletassignment;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
		// request.getRequestDispatcher("addmovie.html").forward(request,
		// response);
		// response.sendRedirect("loginform.html");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = new User(username, password);
		PrintWriter out = response.getWriter();

		if (isValidUser(user)) {
			System.out.println("User is Valid");
			redirectToDesk(request, response,username);
			startSession(request, username);
			return;
		} else {
			System.out.println("User is invalid");
			response.setContentType("text/html");
			out.print("<center><font color=red><h3>Invalid Credentials!</h3></font></center>");
			invalidateSession(request);
			request.getRequestDispatcher("loginform.html").include(request, response);
			return;
		}
	}

	private void redirectToLogin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.getRequestDispatcher("loginform.html").include(request, response);
		
	}

	private void redirectToDesk(HttpServletRequest request, HttpServletResponse response, String username) throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		out.print("<center><font color=red><h3>Welcome " + username + "</h3></font></center>");
		request.getRequestDispatcher("desk.html").include(request, response);
	}

	private void invalidateSession(HttpServletRequest request) {
		request.getSession(false).invalidate();
	}

	private boolean isValidUser(User user) {
		return new RegisteredUsers().getUsersData().contains(user);
	}

	private void startSession(HttpServletRequest request, String username) {
		HttpSession session = request.getSession(true);
		session.setAttribute("username", username);
	}

}
