package dii2dam.movieApp.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import dii2dam.movieApp.models.a;

public class LocationDaoImpl extends CommonDaoImpl<a> implements LocationDaoInt {

	private Session session;

	public LocationDaoImpl(Session session) {
		super(session);
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<a> searchLocationsByUser(Long id) {
		if (!session.getTransaction().equals(TransactionStatus.ACTIVE)) {
			session.getTransaction().begin();
		}
		return session.createQuery("FROM location WHERE user_id = '" + id + "'").list();
	}

	@Override
	public a searchLocationByUserIdAndName(Long currentUser, String value) {
		if (!session.getTransaction().equals(TransactionStatus.ACTIVE)) {
			session.getTransaction().begin();
		}
		return (a)session.createQuery("FROM location WHERE user_id = '" + currentUser + "' and name = '" + value + "'").uniqueResult();
	}

}
