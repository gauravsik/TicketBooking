package com.bitwise.jspassignment;

import java.util.ArrayList;
import java.util.List;

public class BookingList {
	List<Booking> bookings = new ArrayList<Booking>();
	public void addBooking(Booking booking) {
		bookings.add(booking);
	}
	
	public List<Booking> getBookings(){
		return this.bookings;
	}

}
