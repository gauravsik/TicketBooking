package com.bitwise.jspassignment;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.bitwise.servletassignment.Movie;
import com.bitwise.servletassignment.MovieList;
import com.bitwise.jspassignment.*;

public class PrintBookings extends TagSupport{
	public int doStartTag() throws JspException {
		//PageContext pageContext = (PageContext) getJspContext();
		HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
		HttpServletResponse response = (HttpServletResponse)pageContext.getResponse();
		JspWriter out = pageContext.getOut();
		BookingList bookingList = (BookingList)request.getSession(false).getAttribute("bookingList");
		List<Booking> bookings = bookingList.getBookings();
		
		Collections.sort(bookings, new Comparator<Booking>() {
		    public int compare(Booking b1, Booking b2) {
		        return b1.getDob().compareTo(b2.getDob());
		    }
		});
		
		for(Booking b : bookings){
			try {
				out.print("<center><table border=1>");
				out.print("<tr>");
				out.print("<td>Customer Name</td>");
				out.print("<td>Address</td>");
				out.print("<td>Movie Name</td>");
				out.print("<td>Phone Number</td>");
				out.print("<td>Seats</td>");
				out.print("<td>Date Of Booking</td>");
				out.print("</tr>");
				out.print("<tr>");
				out.print("<td>" + b.getCustName() + "</td>");
				out.print("<td>" + b.getAddress() + "</td>");
				out.print("<td>" + b.getMname() + "</td>");
				out.print("<td>" + b.getPhone() + "</td>");
				out.print("<td>" + b.getSeats() + "</td>");
				out.print("<td>" + b.getDob() + "</td>");
				out.print("</tr>");
				out.print("</table><center>");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		}
		return SKIP_BODY;
  }
}

