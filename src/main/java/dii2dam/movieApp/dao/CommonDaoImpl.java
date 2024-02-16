package dii2dam.movieApp.dao;

import java.util.List;
import java.lang.reflect.ParameterizedType;

import org.hibernate.Session;
import org.hibernate.resource.transaction.spi.TransactionStatus;

public abstract class CommonDaoImpl<T> implements CommonDaoI<T> {

	private Class<T> entityClass;
	private Session session;

	@SuppressWarnings("unchecked")
	protected CommonDaoImpl(Session session) {
		setEntityClass((Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
		this.session = session;
	}

	@Override
	public void insert(final T paramT) {
		if (!session.getTransaction().equals(TransactionStatus.ACTIVE)) {
			session.getTransaction().begin();
		}
		session.save(paramT);
		session.flush();
		session.getTransaction().commit();
	}

	@Override
	public void update(final T paramT) {
		if (!session.getTransaction().equals(TransactionStatus.ACTIVE)) {
			session.getTransaction().begin();
		}
		session.saveOrUpdate(paramT);
		session.getTransaction().commit();
	}

	@Override
	public void delete(final T paramT) {
		if (!session.getTransaction().equals(TransactionStatus.ACTIVE)) {
			session.getTransaction().begin();
		}
		session.delete(paramT);
		session.getTransaction().commit();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<T> searchAll() {
		System.out.println("FROM " + this.entityClass.getName());
		if (!session.getTransaction().getStatus().equals(TransactionStatus.ACTIVE)) {
			session.getTransaction().begin();
		}
		return session.createQuery("FROM " + this.entityClass.getName()).list();
	}

	public Class<T> getEntityClass() {
		return entityClass;
	}

	public void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}
}