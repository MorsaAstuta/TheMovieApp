package dii2dam.movieApp.models;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import dii2dam.movieApp.utils.Manager;
import javafx.scene.image.Image;

public class Movie implements java.io.Serializable {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "title")
	private String title;

	@Column(name = "name")
	private String name;

	@Column(name = "company_id")
	private Long companyId;

	@Column(name = "media_type")
	private String media_type;

	@Column(name = "release_date")
	private String release_date;

	@Column(name = "first_air_date")
	private String first_air_date;

	@Column(name = "overview")
	private String overview;

	@Column(name = "poster_path")
	private String poster_path;

	@Column(name = "watch_date")
	private String watchDate;

	@Column(name = "global_rating")
	private Double vote_average;

	@Column(name = "user_rating")
	private Double userRating;

	@Column(name = "review")
	private String review;

	@Column(name = "time")
	private int time;

	@OneToMany(mappedBy = "", cascade = CascadeType.ALL)
	private Set<Review> reviews = new HashSet<Review>(0);

	@Column(name = "location_id")
	private Long locationId;

	@OneToMany(mappedBy = "", cascade = CascadeType.ALL)
	private Set<Actor> actors = new HashSet<Actor>(0);

	@OneToMany(mappedBy = "", cascade = CascadeType.ALL)
	private Set<Integer> genre_ids = new HashSet<Integer>(0);

	@Column
	private Director director;

	protected Movie() {
	}

	public Movie(Long id, String title, Long companyId, String releaseDate, String overview, String posterPath,
			String watchDate, Double globalRating, Double userRating, String review, Long locationId,
			Director director) {
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
		setDirector(director);

	}
	
	private String getActorImageUrl(Set<Actor> actors) {
	    String imageUrl = "";
	    for (Actor actor : actors) {
	        // Concatena las URL de las imágenes de los actores
	        imageUrl += "https://image.tmdb.org/t/p/w500" + actor.getProfilePath() + ", ";
	    }
	    // Elimina la última coma y espacio
	    if (!imageUrl.isEmpty()) {
	        imageUrl = imageUrl.substring(0, imageUrl.length() - 2);
	    }
	    return imageUrl;
	}


	public Director getDirector() {
		return director;
	}

	public void setDirector(Director director) {
		this.director = director;
	}

	public Movie(String title, String releaseDate, String overview) {
		setTitle(title);
		setReleaseDate(releaseDate);
		setOverview(overview);
	}

	public String getTitle() {
		switch (this.media_type) {
		case "tv":
			return name;
		case "movie":
			return title;
		}
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
		switch (this.media_type) {
		case "tv":
			return first_air_date;
		case "movie":
			return release_date;
		}
		return release_date;
	}

	public void setReleaseDate(String releaseDate) {
		this.release_date = releaseDate;
	}

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public String getPosterPath() {
		return poster_path;
	}

	public void setPosterPath(String posterPath) {
		this.poster_path = posterPath;
	}

	public String getWatchDate() {
		return watchDate;
	}

	public void setWatchDate(String watchDate) {
		this.watchDate = watchDate;
	}

	public Double getRatingGlobal() {
		return vote_average;
	}

	public void setRatingGlobal(Double globalRating) {
		this.vote_average = globalRating;
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

	public String getGenre() {
		String output = "";
		int item = 0;
		for (Integer genre_id : genre_ids) {
			output += Manager.genreById.get(genre_id);
			item++;
			if (item != genre_ids.size())
				output += ", ";
		}
		return output;
	}

	public String getName() {
	  return name;
	}

	public void setName(String name) {
	  this.name = name;
	}

	public String getMedia_type() {
	  return media_type;
	}

	public void setMedia_type(String media_type) {
	  this.media_type = media_type;
	}

	public String getRelease_date() {
	  return release_date;
	}

	public void setRelease_date(String release_date) {
	  this.release_date = release_date;
	}

	public String getFirst_air_date() {
	  return first_air_date;
	}

	public void setFirst_air_date(String first_air_date) {
	  this.first_air_date = first_air_date;
	}

	public String getPoster_path() {
	  return poster_path;
	}

	public void setPoster_path(String poster_path) {
	  this.poster_path = poster_path;
	}

	public Double getVote_average() {
	  return vote_average;
	}

	public void setVote_average(Double vote_average) {
	  this.vote_average = vote_average;
	}

	public int getTime() {
	  return time;
	}

	public void setTime(int time) {
	  this.time = time;
	}

	public Set<Review> getReviews() {
	  return reviews;
	}

	public void setReviews(Set<Review> reviews) {
	  this.reviews = reviews;
	}

	public Set<Actor> getActors() {
	  return actors;
	}

	public void setActors(Set<Actor> actors) {
	  this.actors = actors;
	}

	public Set<Integer> getGenre_ids() {
	  return genre_ids;
	}

	public void setGenre_ids(Set<Integer> genre_ids) {
	  this.genre_ids = genre_ids;
	}
	

}
