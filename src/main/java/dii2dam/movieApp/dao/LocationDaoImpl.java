package dii2dam.movieApp.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import dii2dam.movieApp.models.Location;

public class LocationDaoImpl extends CommonDaoImpl<Location> implements LocationDaoInt {

	private Session session;

	public LocationDaoImpl(Session session) {
		super(session);
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Location> searchLocationsByUser(Long id) {
		if (!session.getTransaction().equals(TransactionStatus.ACTIVE)) {
			session.getTransaction().begin();
		}
		return session.createQuery("FROM Location WHERE user_id = '" + id + "'").list();
	}

	@Override
	public Location searchLocationByUserIdAndName(Long currentUser, String value) {
		if (!session.getTransaction().equals(TransactionStatus.ACTIVE)) {
			session.getTransaction().begin();
		}
		return (Location)session.createQuery("FROM Location WHERE user_id = '" + currentUser + "' and name = '" + value + "'").uniqueResult();
	}

	@Override
	public Location searchById(Long id) {
		if (!session.getTransaction().equals(TransactionStatus.ACTIVE)) {
			session.getTransaction().begin();
		}
		return (Location)session.createQuery("FROM Location WHERE id = '" + id + "'").uniqueResult();
	}

}
