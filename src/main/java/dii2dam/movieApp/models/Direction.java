package dii2dam.movieApp.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Direction {

	@Id
	@Column(name = "director_id")
	private Long director_id;

	@Id
	@Column(name = "movie_id")
	private Long movie_id;
	
	public Direction() {
	}
	
	public Direction(Long movie_id, Long director_id) {
		setMovie_id(movie_id);
		setDirector_id(director_id);
	}

	public Long getDirector_id() {
		return director_id;
	}

	public void setDirector_id(Long director_id) {
		this.director_id = director_id;
	}

	public Long getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(Long movie_id) {
		this.movie_id = movie_id;
	}

}
