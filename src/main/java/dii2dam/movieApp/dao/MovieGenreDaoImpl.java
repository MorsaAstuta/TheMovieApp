package dii2dam.movieApp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import dii2dam.movieApp.models.MovieGenre;

public class MovieGenreDaoImpl extends CommonDaoImpl<MovieGenre> implements MovieGenreDaoI {

	private Session session;

	public MovieGenreDaoImpl(Session session) {
		super(session);
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MovieGenre> searchByMovieId(Long id) {
		if (!session.getTransaction().equals(TransactionStatus.ACTIVE)) {
			session.getTransaction().begin();
		}
		return session.createQuery("from MovieGenre where movie_id = '" + id + "'").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MovieGenre> searchByGenreId(Long id) {
		if (!session.getTransaction().equals(TransactionStatus.ACTIVE)) {
			session.getTransaction().begin();
		}
		return session.createQuery("from MovieGenre where genre_id = '" + id + "'").list();
	}

}
