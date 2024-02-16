package dii2dam.movieApp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import dii2dam.movieApp.models.Genre;

public class GenreDaoImpl extends CommonDaoImpl<Genre> implements GenreDaoI {

	private Session session;

	public GenreDaoImpl(Session session) {
		super(session);
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Genre> searchByGenreId(long id) {
		if (!session.getTransaction().equals(TransactionStatus.ACTIVE)) {
			session.getTransaction().begin();
		}
		return session.createQuery("FROM Genre INNER JOIN moviegenre ON moviegenre.movie_id = '" + id + "'").list();
	}

	@Override
	public Genre searchByGenreName(String name) {
		if (!session.getTransaction().equals(TransactionStatus.ACTIVE)) {
			session.getTransaction().begin();
		}
		return (Genre) session.createQuery("FROM Genre where name = '" + name + "'").uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Genre> searchGenresByMovieId(long idMovie) {
		if (!session.getTransaction().equals(TransactionStatus.ACTIVE)) {
			session.getTransaction().begin();
		}
		return session.createQuery("from Genre inner join moviegenre on moviegenre.movie_id = '" + idMovie + "'").list();
	}

	@Override
	public Genre searchById(Long id) {
		if (!session.getTransaction().equals(TransactionStatus.ACTIVE)) {
			session.getTransaction().begin();
		}
		return (Genre) session.createQuery("from Genre where id = '" + id + "'").uniqueResult();
	}
}
