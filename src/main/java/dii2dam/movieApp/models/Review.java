package dii2dam.movieApp.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Review {

  @Id
  @Column(name="username")
  private String username;
	
  @Column(name="content")
  private String content;
	
  @Column(name="avatar_path")
  private String avatar_path;
	
  @Column(name="created_at")
  private String created_at;
	
  @Column(name="movie_id")
  private Long movie_id;

  public Review(String username, String content, String avatar_path, String created_at, Long movie_id) {
  	setUsername(username);
  	setContent(content);
  	setAvatar_path(avatar_path);
  	setCreated_at(created_at);
  	setMovie_id(movie_id);
  }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAvatar_path() {
		return avatar_path;
	}

	public void setAvatar_path(String avatar_path) {
		this.avatar_path = avatar_path;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public Long getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(Long movie_id) {
		this.movie_id = movie_id;
	}
  
}
