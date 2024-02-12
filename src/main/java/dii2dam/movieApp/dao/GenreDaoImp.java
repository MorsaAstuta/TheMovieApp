package dii2dam.movieApp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import dii2dam.movieApp.models.Actor;
import dii2dam.movieApp.models.Genre;

public class GenreDaoImp extends CommonDaoImpl<Genre> implements GenreDaoInt {

	private Session session;

	public GenreDaoImp(Session session) {
		super(session);
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Genre> searchByGenreId(long id) {
		if (!session.getTransaction().equals(TransactionStatus.ACTIVE)) {
			session.getTransaction().begin();
		}
		return session.createQuery("FROM genre INNER JOIN moviegenre ON " + id + "= moviegenre.movie_id").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Genre> searchByGenreName(String name) {
		if (!session.getTransaction().equals(TransactionStatus.ACTIVE)) {
			session.getTransaction().begin();
		}
		return session.createQuery("FROM genre where name =" + name).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Genre> searchGenresByMovieId(long idMovie) {
		if (!session.getTransaction().equals(TransactionStatus.ACTIVE)) {
			session.getTransaction().begin();
		}
		return session.createQuery("from genre inner join moviegenre on" + idMovie + "= moviegenre.movie_id").list();
	}
}
