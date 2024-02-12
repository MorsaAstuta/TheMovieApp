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

  @Column(name="register_date")
  private String register_date;
	
  @Transient
	private String profile_path;

  @Transient
	private String known_for_department;

	public Actor() {

	}

	public Actor(Long id, String name, String profile_path) {
		super();
		setId(id);
		setName(name);
		setProfilePath(profile_path);
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

	public String getProfilePath() {
		return profile_path;
	}

	public void setProfilePath(String profile_path) {
		this.profile_path = profile_path;
	}

	public String getKnownForDepartment() {
		return known_for_department;
	}

	public void setKnownForDepartment(String known_for_department) {
		this.known_for_department = known_for_department;
	}

}
