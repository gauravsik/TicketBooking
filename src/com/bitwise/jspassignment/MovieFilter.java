package com.bitwise.jspassignment;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bitwise.servletassignment.Movie;
//import javax.servlet.annotation.WebFilter;
import com.bitwise.servletassignment.MovieList;

//@WebFilter("/MovieFilter")
public class MovieFilter implements Filter {

	public MovieFilter() {

	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		String custName = request.getParameter("custname");
		String address = request.getParameter("custadd");
		String phone = request.getParameter("custphone");
		String mname = request.getParameter("addedmovies");
		Integer seats = Integer.parseInt(request.getParameter("seatsbooked"));
		String dob = request.getParameter("date");
		Booking booking = new Booking(custName, address, phone, mname, seats, dob);
		MovieList movieList = (MovieList) req.getSession(false).getAttribute("movieList");
		List<Movie> movies = movieList.getMovies();
		
		if (custName == null) {
			out.print("<center><font color=red><h1>Please Enter Your Name</h1></font></center>");
			req.getRequestDispatcher("moviebooking.jsp").include(req, res);
		} else if (address == null) {
			out.print("<center><font color=red><h1>Invalid Address</h1></font></center>");
			req.getRequestDispatcher("moviebooking.jsp").include(req, res);
		} else if (phone == null || !phone.matches("\\d{10}")) {
			out.print("<center><font color=red><h1>Incorrect Phone No</h1></font></center>");
			req.getRequestDispatcher("moviebooking.jsp").include(req, res);
		} else if (true) {
			for (Movie m : movies) {
				if (m.getMovieName().equals(mname) && seats > 0) {
					int availbleSeats = m.getTotalSeatsAvailable();
					System.out.println(availbleSeats);
					availbleSeats -= seats;
					System.out.println(availbleSeats);
					if (availbleSeats < 0) {
						out.print("<center><font color=red><h1>No Seats Available</h1></font></center>");
						m.setTotalSeatsAvailable(0);
						req.getRequestDispatcher("moviebooking.jsp").include(req, res);
					} else {
						m.setTotalSeatsAvailable(availbleSeats);
						out.print("<center><font color=red><h1>Tickets Booked Sucessfully</h1></font></center>");
						chain.doFilter(req, res);
					}
				} else {
					out.print("<center><font color=red><h1>No such show</h1></font></center>");
					req.getRequestDispatcher("moviebooking.jsp").include(req, res);
				}
			}
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
