package dii2dam.movieApp.dao;

import java.util.List;

import dii2dam.movieApp.models.Genre;

public interface GenreDaoInt extends CommonDaoInt<Genre> {
  public List<Genre> searchByGenreId(final long id);
  public List<Genre> searchByGenreName(final String name);
  public List <Genre> searchGenresByMovieId(final long idMovide);
}
