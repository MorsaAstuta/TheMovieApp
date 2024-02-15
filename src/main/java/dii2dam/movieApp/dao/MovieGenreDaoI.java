package dii2dam.movieApp.dao;

import java.util.List;

import dii2dam.movieApp.models.MovieGenre;

public interface MovieGenreDaoI extends CommonDaoInt<MovieGenre>{
  public List<MovieGenre> searchByMovieId(final Long id);
  public List<MovieGenre> searchByGenreId(final Long id);
}
