package dii2dam.movieApp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import dii2dam.movieApp.models.Actor;

public class ActorDaoImpl extends CommonDaoImpl<Actor> implements ActorDaoInt{

	private Session session;
	public ActorDaoImpl(Session session) {
		super(session);
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Actor> searchByActorId(int id) {
		if (!session.getTransaction().equals(TransactionStatus.ACTIVE)) {
			  session.getTransaction().begin();
			}
			return session.createQuery("from actor where actor_id = '" + id + "'").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Actor> searchByName(String name) {
		if (!session.getTransaction().equals(TransactionStatus.ACTIVE)) {
			  session.getTransaction().begin();
			}
			return session.createQuery("from actor inner join user on actor.actor_id = actor_id where actor.name = '" + name + "'").list();	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Actor> searchBySurname(String surname) {
		if (!session.getTransaction().equals(TransactionStatus.ACTIVE)) {
			  session.getTransaction().begin();
			}
			return session.createQuery("from actor inner join user on actor.actor_id = actor_id where actor.surname = '" + surname + "'").list();	}	

	@SuppressWarnings("unchecked")
	@Override
	public List<Actor> searchByBithdate(String birthdate) {
		if (!session.getTransaction().equals(TransactionStatus.ACTIVE)) {
			  session.getTransaction().begin();
			}
			return session.createQuery("from actor where birthdate = '" + birthdate + "'").list();
		  }  

}
