package dii2dam.movieApp.models;

import java.util.Date;

import javax.persistence.Column;

public class Actor {

	@Column(name = "actor_id")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "surname")
	private String surname;
	@Column(name = "birthdate")
	private String birthdate;

	public Actor(int id, String name, String surname, String birthdate) {
		super();
		setId(id);
		setName(name);
		setSurname(surname);
		setBirthdate(birthdate);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

}
