package dii2dam.movieApp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.resource.transaction.spi.TransactionStatus;
import dii2dam.movieApp.models.Director;

public class DirectorDaoImpl extends CommonDaoImpl<Director> implements DirectorDaoI {

	private Session session;

	public DirectorDaoImpl(Session session) {
		super(session);
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Director> searchByDirectorId(Long id) {
		if (!session.getTransaction().equals(TransactionStatus.ACTIVE)) {
			session.getTransaction().begin();
		}
		return session.createQuery("FROM Director INNER JOIN Direction ON Direction.movie_id = '" + id + "'").list();
	}

	@Override
	public Director searchByName(String name) {
		if (!session.getTransaction().equals(TransactionStatus.ACTIVE)) {
			session.getTransaction().begin();
		}
		return (Director) session.createQuery("FROM Director where name = '" + name + "'").uniqueResult();
	}

	@Override
	public Director searchById(Long id) {
		if (!session.getTransaction().equals(TransactionStatus.ACTIVE)) {
			session.getTransaction().begin();
		}
		return (Director) session.createQuery("FROM Director where id = '" + id + "'").uniqueResult();
	}

}
