package dii2dam.movieApp.dao;

import java.util.List;

import dii2dam.movieApp.models.Cast;

public interface CastDaoI extends CommonDaoInt<Cast>{
  public List<Cast> searchByMovieId(final Long id);
  public List<Cast> searchByActorId(final Long id);
}
