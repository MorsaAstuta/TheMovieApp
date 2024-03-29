package dii2dam.movieApp.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import dii2dam.movieApp.models.Movie;

public class MovieDaoImpl extends CommonDaoImpl<Movie> implements MovieDaoI {

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
		return session.createQuery("from Movie where user_id = '" + id + "'").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Movie> searchMoviesOrderByRating() {
		if (!session.getTransaction().equals(TransactionStatus.ACTIVE)) {
			session.getTransaction().begin();
		}
		return session.createQuery("from Movie order by rating desc").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Movie> searchMoviesByUserIdOrderByRating(Long id) {
		if (!session.getTransaction().equals(TransactionStatus.ACTIVE)) {
			session.getTransaction().begin();
		}
		return session.createQuery("from Movie where user_id = " + id + " order by rating desc").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Movie> searchMoviesByUserIdAndName(Long id, String name) {
		if (!session.getTransaction().equals(TransactionStatus.ACTIVE)) {
			session.getTransaction().begin();
		}
		return session.createQuery("from Movie where user_id = " + id + " and title like '%" + name + "%'").list();
	}

}
