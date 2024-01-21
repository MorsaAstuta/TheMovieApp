package dii2dam.movieApp;


import dii2dam.movieApp.dao.UserDaoImpl;

import java.util.List;

import dii2dam.movieApp.dao.ActorDaoImpl;
import dii2dam.movieApp.dao.ReviewDaoImpl;
import dii2dam.movieApp.models.User;
import dii2dam.movieApp.models.Actor;
import dii2dam.movieApp.models.Review;
import dii2dam.movieApp.utils.HibernateUtils;

public class ADD_TestMain {
  public static void main(String[] args) {
	HibernateUtils.begin();
	HibernateUtils.open();
	try {
	  
	  // User insertion test
	  System.out.println("\nINSERT TEST - User");
	  UserDaoImpl userDao = new UserDaoImpl(HibernateUtils.session);
	  userDao.insert(new User("whiteshark", "wh1t3sh4rk", "2024-01-01", "white@shark.sea"));
	  userDao.insert(new User("dolphin", "d0lph1n", "2024-01-02", "dol@phin.sea"));
	  
	  // Actor insertion test
	  System.out.println("\nINSERT TEST - Actor");
	  ActorDaoImpl actorDao = new ActorDaoImpl(HibernateUtils.session);
	  actorDao.insert(new Actor(1, "Thomas" , "Jeffrey Hanks", "9 de julio de 1956"));
	  actorDao.insert(new Actor(2, "Christian", "Charles Philip Bale","30 de enero de 1974"));
	  // Review insertion test
	  System.out.println("\nINSERT TEST - Review");
	  ReviewDaoImpl reviewDao = new ReviewDaoImpl(HibernateUtils.session);
	  reviewDao.insert(new Review(Long.parseLong("1"), "Me ha encantado esta peli o algo ns", "2024-01-10"));
	  reviewDao.insert(new Review(Long.parseLong("1"), "Esta peli es mu mala", "2024-01-12"));
	  reviewDao.insert(new Review(Long.parseLong("2"), "Tremenda peli honestamente", "2024-01-10"));
	  
	  // test select
	  List<Actor> actors = actorDao.searchByName("Thomas");

	  for (Actor actor : actors) {
		    System.out.println("Actor ID: " + actor.getId());
		    System.out.println("First Name: " + actor.getName());
		    System.out.println("Last Name: " + actor.getSurname());
		    System.out.println("Birthdate: " + actor.getBirthdate());
		}
	  
	} catch (Exception e) {
		System.out.println(e);
	} finally {
		HibernateUtils.close();
	}
  }

}
