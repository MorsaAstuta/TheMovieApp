package dii2dam.movieApp.dao;

import java.util.List;

import dii2dam.movieApp.models.Direction;

public interface DirectionDaoI extends CommonDaoInt<Direction>{
  public List<Direction> searchByMovieId(final Long id);
  public List<Direction> searchByDirectorId(final Long id);
}
