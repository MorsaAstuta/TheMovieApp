package dii2dam.movieApp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import dii2dam.movieApp.models.User;

public class UserDaoImpl extends CommonDaoImpl<User> implements UserDaoInt {
  private Session session;
  
  public UserDaoImpl(Session session) {
	super(session);
	this.session = session;
  }

  
  @Override
  public User searchByUsername(final String username) {
	if (!session.getTransaction().equals(TransactionStatus.ACTIVE)) {
	  session.getTransaction().begin();
	}
	return (User)session.createQuery("from User where username='" + username + "'").uniqueResult();
  }

  @Override
  public User searchByEmail(final String email) {
	if (!session.getTransaction().equals(TransactionStatus.ACTIVE)) {
	  session.getTransaction().begin();
	}
	return (User)session.createQuery("from User where mail='" + email + "'").uniqueResult();
  }

  @Override
  @SuppressWarnings("unchecked")
  public List<User> searchBySignDate(final String signDate) {
	if (!session.getTransaction().equals(TransactionStatus.ACTIVE)) {
	  session.getTransaction().begin();
	}
	return session.createQuery("from User where sign_date='" + signDate + "'").list();
  }
  public boolean isEmailInUse(String email) {
      boolean inUse = false;
      User user = searchByEmail(email);
      if (user != null) {
          inUse = true;
      }
      return inUse;
  }
  public boolean isUsernameInUse(String username) {
      boolean inUse = false;
      User user = searchByUsername(username);
      if (user != null) {
          inUse = true;
      }
      return inUse;
  }
}
