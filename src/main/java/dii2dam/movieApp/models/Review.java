package dii2dam.movieApp.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Review {
	
  @Id
  @Column(name="id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name="user_id")
  private Long userId;
	
  @Column(name="content")
  private String content;
	
  @Column(name="post_date")
  private String postDate;

  public Review(long userId, String content, String postDate) {
	setUserId(userId);
	setContent(content);
	setPostDate(postDate);
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getPostDate() {
    return postDate;
  }

  public void setPostDate(String postDate) {
    this.postDate = postDate;
  }
  
  

}
