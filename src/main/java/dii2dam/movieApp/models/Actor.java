package dii2dam.movieApp.models;


import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
@Entity
public class Actor {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "name")
	private String name;
	@Column(name = "surname")
	private String surname;
	@Column(name = "birth_date")
	private String birthdate;

	public Actor(Long id, String name, String surname, String birthdate) {
		super();
		setId(id);
		setName(name);
		setSurname(surname);
		setBirthdate(birthdate);
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
