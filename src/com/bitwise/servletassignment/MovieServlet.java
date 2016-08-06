package com.bitwise.servletassignment;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
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
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		request.getRequestDispatcher("addmovie.html").include(request, response);
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
			//request.getRequestDispatcher("DisplayServlet").include(request, response);
			
		}
	}
}
