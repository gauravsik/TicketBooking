package com.bitwise.servletassignment;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/DisplayServlet")
public class DisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DisplayServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		MovieList movieList = (MovieList)request.getSession(false).getAttribute("movieList");
		List<Movie> movies = movieList.getMovies();
		if(movies.size()>0)
		{
			out.println("<center><font color=red>Movie Name| Theater Name| Available Seat|	Start Time|	End Time</center>" );
			for (Movie m: movies) {
				out.println("<center>");
				out.println("<form action='MovieServlet' method='post' >");
				out.println("<table>");
				out.println("<input type='hidden' value='" + m.getMovieName() + "' name='moviename'/> ");
				out.println("<input type='hidden' value='" + m.getTheaterName() + "' name='theatername'/> ");
				out.println("<input type='hidden' value='" + m.getTotalSeatsAvailable()+ "' name='seatsavailable'/> ");
				out.println("<input type='hidden' value='" + m.getStartTime() + "' name='starttime'/> ");
				out.println("<input type='hidden' value='" + m.getEndTime() + "' name='endtime'/> ");
				out.println("<tr>");
				out.println("<td>" + m.getMovieName() + "|</td>");
				out.println("<td>" +  m.getTheaterName() + "|</td>");
				out.println("<td>" + m.getTotalSeatsAvailable() + "|</td>");
				out.println("<td>" +  m.getStartTime() + "|</td>");
				out.println("<td>" + m.getEndTime() + "|</td>");
				out.println("<td>" + "<input type='submit' name='submit' value='remove' /> " + "</td>");
				out.println("</tr>");
				out.println("</table>");
				out.println("</form>");
				out.println("</center>");
			}
		}
		else{
			out.write("<center>No movies to display!!<center>");
			out.print("<center><form method='POST' action='addmovie.html'><input type='submit' value='Add movies'></center>");
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
