package dii2dam.movieApp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import dii2dam.movieApp.models.Review;

public class ReviewDaoImpl extends CommonDaoImpl<Review> implements ReviewDaoInt {
  
  private Session session;
  
  public ReviewDaoImpl(Session session) {
	super(session);
	this.session = session;
  }

  @Override
  @SuppressWarnings("unchecked")
  public List<Review> searchByUserId(Long userId) {
	if (!session.getTransaction().equals(TransactionStatus.ACTIVE)) {
	  session.getTransaction().begin();
	}
	return session.createQuery("from review where user_id = '" + userId + "'").list();
  }

  @Override
  @SuppressWarnings("unchecked")
  public List<Review> searchByUsername(String username) {
	if (!session.getTransaction().equals(TransactionStatus.ACTIVE)) {
	  session.getTransaction().begin();
	}
	return session.createQuery("from review inner join user on review.user_id = user.id where user.username = '" + username + "'").list();
  }

  @Override
  @SuppressWarnings("unchecked")
  public List<Review> searchByContent(String content) {
	if (!session.getTransaction().equals(TransactionStatus.ACTIVE)) {
	  session.getTransaction().begin();
	}
	return session.createQuery("from review where content like '%" + content + "%'").list();
  }

  @Override
  @SuppressWarnings("unchecked")
  public List<Review> searchByPostDate(String postDate) {
	if (!session.getTransaction().equals(TransactionStatus.ACTIVE)) {
	  session.getTransaction().begin();
	}
	return session.createQuery("from review where post_date = '" + postDate + "'").list();
  }  
  
}