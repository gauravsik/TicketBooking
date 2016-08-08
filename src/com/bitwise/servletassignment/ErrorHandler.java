package com.bitwise.servletassignment;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/ErrorHandler")
public class ErrorHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ErrorHandler() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	       
	      Throwable throwable = (Throwable)
	      request.getAttribute("javax.servlet.error.exception");
	      response.setContentType("text/html");
	 
	      PrintWriter out = response.getWriter();
	      out.println("<html>\n" + 
	    		  		"<head><title>Error/Exception Information </title></head>\n" + 
	    		  		"<body>\n");
	         out.println("<center><font color=red><h1>" +  throwable.getMessage( ) + 
	        		 "</h1><font><center>");
	         out.print("<a href = desk.html> Go Back </a>");
		     out.println("</body>");
		     out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
