package dii2dam.movieApp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import dii2dam.movieApp.models.Cast;

public class CastDaoImpl extends CommonDaoImpl<Cast> implements CastDaoI {

	private Session session;

	public CastDaoImpl(Session session) {
		super(session);
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cast> searchByMovieId(Long id) {
		if (!session.getTransaction().equals(TransactionStatus.ACTIVE)) {
			session.getTransaction().begin();
		}
		return session.createQuery("from Cast where movie_id = '" + id + "'").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cast> searchByActorId(Long id) {
		if (!session.getTransaction().equals(TransactionStatus.ACTIVE)) {
			session.getTransaction().begin();
		}
		return session.createQuery("from Cast where actor_id = '" + id + "'").list();
	}

}
