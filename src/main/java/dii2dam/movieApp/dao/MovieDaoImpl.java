package dii2dam.movieApp.dao;

import org.hibernate.Session;

import dii2dam.movieApp.models.Movie;

public class MovieDaoImpl extends CommonDaoImpl<Movie> implements MovieDaoInt {
  
  private Session session;

  public MovieDaoImpl(Session session) {
	super(session);
	this.session = session;
  }

}
