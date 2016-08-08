package com.bitwise.jspassignment;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.bitwise.servletassignment.Movie;
import com.bitwise.servletassignment.MovieList;

public class MovieTag extends TagSupport {

	public int doStartTag() throws JspException {
		// PageContext pageContext = (PageContext) getJspContext();
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		HttpServletResponse response = (HttpServletResponse) pageContext.getResponse();
		JspWriter out = pageContext.getOut();
		try {
			MovieList movieList = (MovieList) request.getSession(false).getAttribute("movieList");
			List<Movie> movies = movieList.getMovies();

			try {
				out.println("<select id='selectedRecord' name='addedmovies'>");
				for (Movie m : movies) {
					out.println("<option value='" + m.getMovieName() + "'>" + m.getMovieName() + "</option>");
				}
				out.println("</select>");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			try {
				response.sendRedirect("movieerror.jsp");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		return SKIP_BODY;
	}
}
