package dii2dam.movieApp.dao;

import java.util.List;

import dii2dam.movieApp.models.Actor;

public interface CastDaoInt extends CommonDaoInt<Actor>{
  public List<Actor> searchByActorId(final Long id);
  
  public List<Actor> searchByMovieId(final Long id);
  
 
}
