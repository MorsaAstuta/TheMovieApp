package dii2dam.movieApp.dao;

import java.util.List;

import dii2dam.movieApp.models.Review;

public interface ReviewDaoInt extends CommonDaoInt<Review> {
  public List<Review> searchByUserId(final Long userId);
  public List<Review> searchByUsername(final String username);
  public List<Review> searchByContent(final String content);
  public List<Review> searchByPostDate(final String postDate);
}
