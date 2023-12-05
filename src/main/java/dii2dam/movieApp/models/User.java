package dii2dam.movieApp.models;

import dii2dam.movieApp.utils.Manager;

public class User {
  private String username;
  private String password;
  private String signDate;
  private String mail;
  
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
