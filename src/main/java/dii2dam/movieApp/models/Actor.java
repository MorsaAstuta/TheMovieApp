package dii2dam.movieApp.models;


import javax.persistence.*;
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
	 @Column(name="actor_path")
	  private String actor_path;
	 

	

	public String getActor_path() {
		return actor_path;
	}

	public void setActor_path(String actor_path) {
		this.actor_path = actor_path;
	}

	public Actor() {
		
	}
	
	public Actor(Long id, String name, String surname, String birthdate) {
		super();
		setId(id);
		setName(name);
		setSurname(surname);
		setBirthdate(birthdate);
		setActor_path(actor_path);
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
