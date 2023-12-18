package dii2dam.movieApp.models;

import javafx.scene.image.Image;

public class Movie {

  private Integer id;
  private String title;
  private Integer company_id;
  private String release_date;
  private String overview;
  private String poster_path;
  private String watch_date;
  private Double rating_global;
  private Double rating_user;
  private String review;
  private Integer location_id;
  
  public Movie(Integer id, String title, Integer company_id, String release_date, String overview, String poster_path, String watch_date, Double rating_global, Double rating_user, String review, Integer location_id) {
	setId(id);
	setTitle(title);
	setCompany_id(company_id);
	setRelease_date(release_date);
	setOverview(overview);
	setPoster_path(poster_path);
	setWatch_date(watch_date);
	setRating_global(rating_global);
	setRating_user(rating_user);
	setReview(review);
	setLocation_id(location_id);
  }
  
  public Movie(String title, String release_date, String overview) {
	setTitle(title);
	setRelease_date(release_date);
	setOverview(overview);
  }
  
  public String getTitle() {
	return title;
  }
  
  public void setTitle(String title) {
	this.title = title;
  }
  
  public Integer getId() {
	return id;
  }
  
  public void setId(Integer id) {
	this.id = id;
  }
  
  public Integer getCompany_id() {
	return company_id;
  }
  
  public void setCompany_id(Integer company_id) {
	this.company_id = company_id;
  }

  public String getRelease_date() {
	return release_date;
  }

  public void setRelease_date(String release_date) {
	this.release_date = release_date;
  }

  public String getOverview() {
	return overview;
  }

  public void setOverview(String overview) {
	this.overview = overview;
  }

  public String getPoster_url() {
	return poster_path;
  }

  public void setPoster_path(String poster_url) {
	this.poster_path = poster_url;
  }
  
  public String getWatch_date() {
	return watch_date;
  }
  
  public void setWatch_date(String watch_date) {
	this.watch_date = watch_date;
  }
  
  public Double getRating_global() {
	return rating_global;
  }
  
  public void setRating_global(Double rating_global) {
	this.rating_global = rating_global;
  }

  public Double getRating_user() {
	return rating_user;
  }
  
  public void setRating_user(Double rating_user) {
	this.rating_user = rating_user;
  }

  public String getReview() {
	return review;
  }

  public void setReview(String review) {
	this.review = review;
  }

  public Integer getLocation_id() {
	return location_id;
  }

  public void setLocation_id(Integer location_id) {
	this.location_id = location_id;
  }
	
}
