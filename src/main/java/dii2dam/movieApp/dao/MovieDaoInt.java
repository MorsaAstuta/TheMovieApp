package dii2dam.movieApp.dao;

import java.util.List;

import dii2dam.movieApp.models.Movie;

public interface MovieDaoInt extends CommonDaoInt<Movie> {
	public List<Movie> searchMoviesByUser(Long id);

	List<Movie> searchMoviesOrderByRating();

	List<Movie> searchMoviesByUserIdOrderByRating(Long id);

	List<Movie> searchMoviesByUserIdAndName(Long id, String name);

}
