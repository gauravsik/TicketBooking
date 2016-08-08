package com.bitwise.servletassignment;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebServlet("/MovieServlet")
public class MovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MovieServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("addmovie.jsp");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet (request,response);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String movieName = request.getParameter("moviename");
		String theaterName = request.getParameter("theatername");
		Integer totalSeatsAvailable = Integer.parseInt(request.getParameter("seatsavailable")) ;
		String startTime = request.getParameter("starttime");
		String endTime = request.getParameter("endtime");
		
		HttpSession session = request.getSession(false);
		if (request.getParameter("submit").equalsIgnoreCase("add")) {
			if (request.getSession(false).getAttribute("movieList") == null) {
				MovieList movieList = new MovieList();
				movieList.addMovie(new Movie(movieName, theaterName, totalSeatsAvailable, startTime, endTime));
				session.setAttribute("movieList", movieList);
			} else {
				MovieList movieList = (MovieList) session.getAttribute("movieList");
				movieList.addMovie(new Movie(movieName, theaterName, totalSeatsAvailable, startTime, endTime));
			}
		}
		
	if(request.getParameter("submit").equalsIgnoreCase("remove")){
			MovieList movieList = (MovieList) session.getAttribute("movieList");
			movieList.removeMovie(new Movie(movieName, theaterName, totalSeatsAvailable, startTime, endTime));
			out.print("<center><h3>Movie remvoed successfully<h3><center>");		
		}
	out.close();
		
	}
}
