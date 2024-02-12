package dii2dam.movieApp.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import dii2dam.movieApp.models.Movie;

public class MovieDaoImpl extends CommonDaoImpl<Movie> implements MovieDaoInt {

	private Session session;

	public MovieDaoImpl(Session session) {
		super(session);
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Movie> searchMoviesByUser(Long id) {
		if (!session.getTransaction().equals(TransactionStatus.ACTIVE)) {
			session.getTransaction().begin();
		}
		return session.createQuery("from movie where user_id = '" + id + "'").list();
	}

}
