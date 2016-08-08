package com.bitwise.servletassignment;

public class Movie {

	private String movieName;
	private String theaterName;
	private Integer totalSeatsAvailable;
	private String startTime;
	private String endTime;
	
	public Movie(String movieName, String theaterName, Integer totalSeatsAvailable, String startTime, String endTime) 
	{
		this.movieName = movieName;
		this.theaterName = theaterName;
		this.totalSeatsAvailable = totalSeatsAvailable;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	


	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getTheaterName() {
		return theaterName;
	}

	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}

	public Integer getTotalSeatsAvailable() {
		return totalSeatsAvailable;
	}

	public void setTotalSeatsAvailable(Integer totalSeatsAvailable) {
		this.totalSeatsAvailable = totalSeatsAvailable;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
		result = prime * result + ((movieName == null) ? 0 : movieName.hashCode());
		result = prime * result + ((startTime == null) ? 0 : startTime.hashCode());
		result = prime * result + ((theaterName == null) ? 0 : theaterName.hashCode());
		result = prime * result + ((totalSeatsAvailable == null) ? 0 : totalSeatsAvailable.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		if (endTime == null) {
			if (other.endTime != null)
				return false;
		} else if (!endTime.equals(other.endTime))
			return false;
		if (movieName == null) {
			if (other.movieName != null)
				return false;
		} else if (!movieName.equals(other.movieName))
			return false;
		if (startTime == null) {
			if (other.startTime != null)
				return false;
		} else if (!startTime.equals(other.startTime))
			return false;
		if (theaterName == null) {
			if (other.theaterName != null)
				return false;
		} else if (!theaterName.equals(other.theaterName))
			return false;
		if (totalSeatsAvailable == null) {
			if (other.totalSeatsAvailable != null)
				return false;
		} else if (!totalSeatsAvailable.equals(other.totalSeatsAvailable))
			return false;
		return true;
	}
}
