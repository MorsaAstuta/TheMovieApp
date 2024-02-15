package dii2dam.movieApp.models;

import java.util.Date;

import javax.persistence.*;

import dii2dam.movieApp.utils.Manager;

@Entity
public class Location {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "user_id")
	private Long user_id;

	@Column(name = "register_date")
	private String register_date;
	
	public Location() {
	}
	
	public Location(String name) {
		setName(name);
		setUser_id(Manager.getCurrentUser());
		setRegister_date(Manager.getSdf().format(new Date()));
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getRegister_date() {
		return register_date;
	}

	public void setRegister_date(String register_date) {
		this.register_date = register_date;
	}

}

