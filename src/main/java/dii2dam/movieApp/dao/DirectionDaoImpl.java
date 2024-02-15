package dii2dam.movieApp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import dii2dam.movieApp.models.Direction;

public class DirectionDaoImpl extends CommonDaoImpl<Direction> implements DirectionDaoI {

	private Session session;

	public DirectionDaoImpl(Session session) {
		super(session);
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Direction> searchByMovieId(Long id) {
		if (!session.getTransaction().equals(TransactionStatus.ACTIVE)) {
			session.getTransaction().begin();
		}
		return session.createQuery("from Cast where movie_id = '" + id + "'").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Direction> searchByDirectorId(Long id) {
		if (!session.getTransaction().equals(TransactionStatus.ACTIVE)) {
			session.getTransaction().begin();
		}
		return session.createQuery("from Direction where director_id = '" + id + "'").list();
	}

}
