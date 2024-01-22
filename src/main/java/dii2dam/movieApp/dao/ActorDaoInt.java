package dii2dam.movieApp.dao;

import java.util.List;

import dii2dam.movieApp.models.Actor;

public interface ActorDaoInt extends CommonDaoInt<Actor>{
  public List<Actor> searchByActorId(final Long id);
  
  public List<Actor> searchByName(final String name);
  
  public List<Actor> searchBySurname(final String surname);
  
  public List<Actor> searchByBithdate(final String birthdate);
}
