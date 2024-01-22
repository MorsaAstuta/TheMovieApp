package dii2dam.movieApp.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import dii2dam.movieApp.utils.Manager;

@Entity
public class User implements java.io.Serializable {
	
  @Id
  @Column(name="id")
  private Long id;

  @Column(name="username")
  private String username;
	
  @Column(name="password")
  private String password;
	
  @Column(name="sign_date")
  private String signDate;
	
  @Column(name="mail")
  private String mail;
  
  protected User() {
  }

  public User(String username, String password, String signDate, String mail) {
	setUsername(username);
	setPassword(password);
	setSignDate(signDate);
	setMail(mail);
	Manager.addUser(this);
  }
  
  public String getUsername() {
    return username;
  }
  
  public void setUsername(String username) {
    this.username = username;
  }
  
  public String getPassword() {
    return password;
  }
  
  public void setPassword(String password) {
    this.password = password;
  }
  
  public String getSignDate() {
    return signDate;
  }
  
  public void setSignDate(String signDate) {
    this.signDate = signDate;
  }
  
  public String getMail() {
    return mail;
  }
  
  public void setMail(String mail) {
    this.mail = mail;
  }
  
}
