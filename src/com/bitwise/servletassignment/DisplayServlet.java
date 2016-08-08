package com.bitwise.servletassignment;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//@WebServlet("/DisplayServlet")
public class DisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DisplayServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();
		
		MovieList movieList =(MovieList)request.getSession(false).getAttribute("movieList");
		if(movieList != null){
			List<Movie> movies = movieList.getMovies();
		if(movies.size()>0)
		{
			for (Movie m: movies) {
				out.println("<html>");
				out.println("<head><link type='text/css'rel='stylesheet' href='\\WebContent\\style.css'></link></head>");
				out.println("<body>");
				out.println("<center>");
				out.println("<form action='MovieServlet' method='post'>");
				out.println("<table border=1><h1>");
				out.println("<input type='hidden' value='" + m.getMovieName() + "' name='moviename'/> ");
				out.println("<input type='hidden' value='" + m.getTheaterName() + "' name='theatername'/> ");
				out.println("<input type='hidden' value='" + m.getTotalSeatsAvailable()+ "' name='seatsavailable'/> ");
				out.println("<input type='hidden' value='" + m.getStartTime() + "' name='starttime'/> ");
				out.println("<input type='hidden' value='" + m.getEndTime() + "' name='endtime'/> ");
				out.println("<tr>");
				out.println("<td>Movie Name</td>");
				out.println("<td>Theater Name</td>");
				out.println("<td>Total Seats</td>");
				out.println("<td>Start Time</td>");
				out.println("<td>End Time</td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td>" + m.getMovieName() + "</td>");
				out.println("<td>" + m.getTheaterName() + "</td>");
				out.println("<td>" + m.getTotalSeatsAvailable() + "</td>");
				out.println("<td>" + m.getStartTime() + "</td>");
				out.println("<td>" + m.getEndTime() + "</td>");
				out.println("<td>" + "<input type='submit' name='submit' value='remove' /> " + "</td>");
				out.println("</tr>");
				out.println("</h1></table>");
				out.println("</form>");
				out.println("</center>");
				out.println("</body>");
				out.println("</html>");
			}
		}
		else{
			out.write("<center><font color=red><h1>No movies to display!!</h1></font><center>");
			out.print("<center><form method='POST' action='addmovie.jsp'><input type='submit' value='Add movies'></center>");
		}
		}
	else{
		throw new RuntimeException(" Oops!! No movie added yet!");
	}
		out.println("<center><h4 style='border-color: maroon;'><a href='desk.html'>Go Back</a></h4><center>");
		out.close();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
