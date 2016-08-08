package com.bitwise.servletassignment;

import java.util.ArrayList;
import java.util.List;

public class MovieList {
	
	List<Movie> movies = new ArrayList<Movie>();
	
	public List<Movie> getMovies() {
		
		return this.movies;
	}
	
	public void addMovie(Movie movie) {
		System.out.println("in addmovie");
		if(movies.size()<3){
			System.out.println(movies.size());
			movies.add(movie);
		}
		
		else{
			throw new RuntimeException("Cannot add more than 10 movies!!! <br> try again");
		}
	}
	
	@Override
	public String toString() {
		return "MovieList [movies=" + movies + "]";
	}
	public void removeMovie(Movie movie) {
		if(movies.contains(movie)){
			movies.remove(movie);
		}
	
	}

}
