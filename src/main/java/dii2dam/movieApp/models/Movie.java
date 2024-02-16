package dii2dam.movieApp.models;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import dii2dam.movieApp.utils.Manager;

@Entity
public class Movie implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "title")
	private String title;

	@Transient
	private String name;

	@Transient
	private String media_type;

	@Column(name = "release_date")
	private String release_date;

	@Transient
	private String first_air_date;

	@Column(name = "overview")
	private String overview;
	
	@Column(name = "poster_path")
	private String poster_path;

	@Column(name = "rating")
	private Double rating;

	@Column(name = "review")
	private String review;

	@Column(name = "runtime")
	private Integer runtime;

	@Column(name = "user_id")
	private Long user_id;

	@Column(name = "location_id")
	private Long location_id;

	@Column(name = "status")
	private String status;

	@Column(name = "register_date")
	private String register_date;

	@Transient
	private Set<Integer> genre_ids = new HashSet<Integer>(0);

	@Transient
	private Double vote_average;

	protected Movie() {
	}

	public Movie(String title, String release_date, String overview, Integer runtime, String poster_path, Long user_id,
			Long location_id, String review, Double rating) {
		setTitle(title);
		setRelease_date(release_date);
		setOverview(overview);
		setRuntime(runtime);
		setPoster_path(poster_path);
		setUser_id(user_id);
		setLocation_id(location_id);
		setRegister_date(Manager.getSdf().format(new Date()));
		setReview(review);
		setRating(rating);
	}

	public Movie(String title, String release_date, String overview, Integer runtime, String poster_path, Long user_id,
			String review, Double rating) {
		setTitle(title);
		setRelease_date(release_date);
		setOverview(overview);
		setRuntime(runtime);
		setPoster_path(poster_path);
		setUser_id(user_id);
		setRegister_date(Manager.getSdf().format(new Date()));
		setReview(review);
		setRating(rating);
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public String getPoster_path() {
		return poster_path;
	}

	public void setPoster_path(String poster_path) {
		this.poster_path = poster_path;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public Integer getRuntime() {
		return runtime;
	}

	public void setRuntime(Integer runtime) {
		this.runtime = runtime;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public Long getLocation_id() {
		return location_id;
	}

	public void setLocation_id(Long location_id) {
		this.location_id = location_id;
	}

	public Set<Integer> getGenre_ids() {
		return genre_ids;
	}

	public void setGenre_ids(Set<Integer> genre_ids) {
		this.genre_ids = genre_ids;
	}

	public Double getVote_average() {
		return vote_average;
	}

	public void setVote_average(Double vote_average) {
		this.vote_average = vote_average;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRegister_date() {
		return register_date;
	}

	public void setRegister_date(String register_date) {
		this.register_date = register_date;
	}

}
