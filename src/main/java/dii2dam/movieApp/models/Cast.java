package dii2dam.movieApp.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cast implements Serializable {

	@Id
	@Column(name = "actor_id")
	private Long actor_id;

	@Id
	@Column(name = "movie_id")
	private Long movie_id;
	
	public Cast() {
	}
	
	public Cast(Long movie_id, Long actor_id) {
		setMovie_id(movie_id);
		setActor_id(actor_id);
	}

	public Long getActor_id() {
		return actor_id;
	}

	public void setActor_id(Long actor_id) {
		this.actor_id = actor_id;
	}

	public Long getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(Long movie_id) {
		this.movie_id = movie_id;
	}

}
