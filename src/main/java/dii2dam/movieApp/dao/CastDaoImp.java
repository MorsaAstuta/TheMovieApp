package dii2dam.movieApp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import dii2dam.movieApp.models.Actor;

public class CastDaoImp extends CommonDaoImpl<Actor> implements CastDaoInt{

	private Session session;
	public CastDaoImp(Session session) {
		super(session);
		this.session = session;
	}
	@Override
	public List<Actor> searchByActorId(Long id) {
		if (!session.getTransaction().equals(TransactionStatus.ACTIVE)) {
			  session.getTransaction().begin();
			}
		return session.createQuery("FROM cast INNER JOIN actor ON "+id+ 
				"= actor.id").list();
	}
	@Override
	public List<Actor> searchByMovieId(Long id) {
		if (!session.getTransaction().equals(TransactionStatus.ACTIVE)) {
			  session.getTransaction().begin();
			}
		return session.createQuery("FROM cast INNER JOIN movie ON "+id+ 
				"= movie.id").list();
	}


	

}
