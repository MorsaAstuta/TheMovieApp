package dii2dam.movieApp.models;

public class Review {

	private String author;

	private String content;

	private String created_at;

	private Long movie_id;

	private AuthorDetails author_details;

	public Review() {

	}

	public Review(String username, String author, Double rating, String content, String avatar_path, String created_at,
			Long movie_id) {
		setAuthor(author);
		setContent(content);
		setCreated_at(created_at);
		setMovie_id(movie_id);
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public String getUsername() {
		if (author_details.getUsername() != null) {
			return author_details.getUsername();
		}
		else return null;
	}

	public String getAvatar_path() {
		if (author_details.getAvatar_path() != null) {
			return author_details.getAvatar_path();
		}
		else return null;
	}

	public Double getRating() {
		if (author_details.getRating() != null) {
			return author_details.getRating();
		}
		else return null;
	}

}
