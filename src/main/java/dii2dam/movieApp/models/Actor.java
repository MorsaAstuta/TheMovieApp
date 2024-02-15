package dii2dam.movieApp.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import dii2dam.movieApp.utils.Manager;

@Entity
public class Actor implements Serializable {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "register_date")
	private String register_date;

	@Transient
	private String profile_path;

	@Transient
	private String known_for_department;

	public Actor() {
		
	}

	public Actor(String name) {
		setName(name);
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

	public String getRegister_date() {
		return register_date;
	}

	public void setRegister_date(String register_date) {
		this.register_date = register_date;
	}

	public String getProfile_path() {
		return profile_path;
	}

	public void setProfile_path(String profile_path) {
		this.profile_path = profile_path;
	}

	public String getKnown_for_department() {
		return known_for_department;
	}

	public void setKnown_for_department(String known_for_department) {
		this.known_for_department = known_for_department;
	}

}
