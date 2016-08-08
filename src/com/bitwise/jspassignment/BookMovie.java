package com.bitwise.jspassignment;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bitwise.servletassignment.Movie;
import com.bitwise.servletassignment.MovieList;


//@WebServlet("/BookMovie")
public class BookMovie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public BookMovie() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in book movie");
		//response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String custName = request.getParameter("custname");
		String address = request.getParameter("custadd");
		String phone = request.getParameter("custphone");
		String mname = request.getParameter("addedmovies");
		Integer seats = Integer.parseInt(request.getParameter("seatsbooked"));
		String dob = request.getParameter("date");
		
		HttpSession session = request.getSession(false);
		if (request.getParameter("submit").equalsIgnoreCase("book")) {
			BookingList bookingList;
			if (request.getSession(false).getAttribute("bookingList") == null) {
				bookingList = new BookingList();
				bookingList.addBooking(new Booking(custName, address ,phone ,mname ,seats,dob));
				
			} else {
				bookingList = (BookingList)session.getAttribute("bookingList");
				bookingList.addBooking(new Booking(custName, address ,phone ,mname ,seats,dob));
			}
			session.setAttribute("bookingList", bookingList);
		}
		
		request.getRequestDispatcher("desk.html").forward(request, response);
		out.close();
		
	}

}
