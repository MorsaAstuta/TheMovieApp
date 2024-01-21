package dii2dam.movieApp.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import javafx.scene.image.Image;

public class Movie implements java.io.Serializable {
  
  @Id
  @Column(name="id")
  private Long id;
  
  @Column(name="title")
  private String title;
  
  @Column(name="company_id")
  private Long companyId;
  
  @Column(name="release_date")
  private String releaseDate;
  
  @Column(name="overview")
  private String overview;
  
  @Column(name="poster_path")
  private String posterPath;
  
  @Column(name="watch_date")
  private String watchDate;
  
  @Column(name="global_rating")
  private Double globalRating;
  
  @Column(name="user_rating")
  private Double userRating;
  
  @Column(name="review")
  private String review;
  
  @Column(name="director")
  private String director;
  
  @OneToMany(mappedBy="",cascade=CascadeType.ALL)
  private Set<Review> reviews = new HashSet<Review>(0);

  @Column(name="location_id")
  private Long locationId;
  
  @OneToMany(mappedBy="",cascade=CascadeType.ALL)
  private Set<Actor> actors = new HashSet<Actor>(0);
  
  
  protected Movie() {
  }

  public Movie(Long id, String title, Long companyId, String releaseDate, String overview, String posterPath, String watchDate, Double globalRating, Double userRating, String review, Long locationId) {
	setId(id);
	setTitle(title);
	setCompanyId(companyId);
	setReleaseDate(releaseDate);
	setOverview(overview);
	setPosterPath(posterPath);
	setWatchDate(watchDate);
	setRatingGlobal(globalRating);
	setUserRating(userRating);
	setReview(review);
	setLocationId(locationId);
  }
  
  public Movie(String title, String releaseDate, String overview) {
	setTitle(title);
	setReleaseDate(releaseDate);
	setOverview(overview);
  }
  
  public String getTitle() {
	return title;
  }
  
  public void setTitle(String title) {
	this.title = title;
  }
  
  public Long getId() {
	return id;
  }
  
  public void setId(Long id) {
	this.id = id;
  }
  
  public Long getCompanyId() {
	return companyId;
  }
  
  public void setCompanyId(Long companyId) {
	this.companyId = companyId;
  }

  public String getReleaseDate() {
	return releaseDate;
  }

  public void setReleaseDate(String releaseDate) {
	this.releaseDate = releaseDate;
  }

  public String getOverview() {
	return overview;
  }

  public void setOverview(String overview) {
	this.overview = overview;
  }

  public String getPosterPath() {
	return posterPath;
  }

  public void setPosterPath(String posterPath) {
	this.posterPath = posterPath;
  }
  
  public String getWatchDate() {
	return watchDate;
  }
  
  public void setWatchDate(String watchDate) {
	this.watchDate = watchDate;
  }
  
  public Double getRatingGlobal() {
	return globalRating;
  }
  
  public void setRatingGlobal(Double globalRating) {
	this.globalRating = globalRating;
  }

  public Double getUserRating() {
	return userRating;
  }
  
  public void setUserRating(Double userRating) {
	this.userRating = userRating;
  }

  public String getReview() {
	return review;
  }

  public void setReview(String review) {
	this.review = review;
  }

  public Long getLocationId() {
	return locationId;
  }

  public void setLocationId(Long locationId) {
	this.locationId = locationId;
  }
	
}
