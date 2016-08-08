package com.bitwise.servletassignment;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//@WebFilter(filterName = "MovieFilter", urlPatterns = { "/MovieFilter" })
public class InputFilter implements Filter {


    public InputFilter() {
    }


	public void destroy() {
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String movieName = request.getParameter("moviename");
		String theaterName = request.getParameter("theatername");
		Integer totalSeatsAvailable = Integer.parseInt(request.getParameter("seatsavailable")) ;
		//String startTime = request.getParameter("starttime");
		//String endTime = request.getParameter("endtime");
		
		if(movieName == null){
			out.print("<center><font color=red><h1>Inavlid movie name</h1></font></center>");
			request.getRequestDispatcher("addmovie.jsp").include(request, response);
			//out.print("<center><form method='POST' action='addmovie.html'><input type='submit' value='Add movies'></center>");
		}
		else if(theaterName == null){
			out.print("<center><font color=red><h1>Please Enter Theater Name</h1></font></center>");
			request.getRequestDispatcher("addmovie.jsp").include(request, response);
		}
		else if(totalSeatsAvailable <0){
			out.print("<center><font color=red><h1>Incorrect Seats Input</h1></font></center>");
			request.getRequestDispatcher("addmovie.jsp").include(request, response);
		}
		else
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
