package dii2dam.movieApp.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MovieGenre implements Serializable {

	@Id
	@Column(name = "genre_id")
	private Long genre_id;

	@Id
	@Column(name = "movie_id")
	private Long movie_id;

	public MovieGenre() {
	}

	public MovieGenre(Long movie_id, Long genre_id) {
		setMovie_id(movie_id);
		setGenre_id(genre_id);
	}

	public Long getGenre_id() {
		return genre_id;
	}

	public void setGenre_id(Long genre_id) {
		this.genre_id = genre_id;
	}

	public Long getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(Long movie_id) {
		this.movie_id = movie_id;
	}

}
