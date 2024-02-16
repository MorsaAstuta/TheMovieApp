package dii2dam.movieApp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import dii2dam.movieApp.models.Actor;

public class ActorDaoImpl extends CommonDaoImpl<Actor> implements ActorDaoI {

	private Session session;

	public ActorDaoImpl(Session session) {
		super(session);
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Actor> searchByActorId(Long id) {
		if (!session.getTransaction().equals(TransactionStatus.ACTIVE)) {
			session.getTransaction().begin();
		}
		return session.createQuery("FROM Actor INNER JOIN Cast ON Actor.id = " + id).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Actor> searchByMovieId(Long id) {
		if (!session.getTransaction().equals(TransactionStatus.ACTIVE)) {
			session.getTransaction().begin();
		}
		return session.createQuery("FROM Actor INNER JOIN Cast ON Cast.movie_id = '" + id + "'").list();
	}

	@Override
	public Actor searchByName(String name) {
		if (!session.getTransaction().equals(TransactionStatus.ACTIVE)) {
			session.getTransaction().begin();
		}
		return (Actor) session.createQuery("FROM Actor where name = '" + name + "'").uniqueResult();
	}

	@Override
	public Actor searchById(Long id) {
		if (!session.getTransaction().equals(TransactionStatus.ACTIVE)) {
			session.getTransaction().begin();
		}
		return (Actor) session.createQuery("from Actor where id = '" + id + "'").uniqueResult();
	}

}
