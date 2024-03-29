package dii2dam.movieApp.dao;

import java.util.List;

import dii2dam.movieApp.models.Genre;

public interface GenreDaoI extends CommonDaoI<Genre> {
	public List<Genre> searchByGenreId(final long id);

	public Genre searchByGenreName(final String name);

	public List<Genre> searchGenresByMovieId(final long idMovide);

	Genre searchById(Long id);
}
