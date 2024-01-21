package dii2dam.movieApp.dao;

import java.util.List;

import dii2dam.movieApp.models.User;

public interface UserDaoInt extends CommonDaoInt<User> {
  public User searchByUsername(final String username);
  public User searchByEmail(final String email);
  public List<User> searchBySignDate(final String date);
}
