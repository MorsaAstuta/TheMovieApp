package dii2dam.movieApp.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Director implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name")
	private String name;

  @Column(name="register_date")
  private String register_date;
  
  @Transient
	private String known_for_department;

	public Director() {

	}

	public Director(int id, String name, String known_for_department) {
		super();
		setId(id);
		setName(name);
		setKnownForDepartment(known_for_department);
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

	public String getKnownForDepartment() {
		return known_for_department;
	}

	public void setKnownForDepartment(String known_for_department) {
		this.known_for_department = known_for_department;
	}

	public String getKnown_for_department() {
		return known_for_department;
	}

	public void setKnown_for_department(String known_for_department) {
		this.known_for_department = known_for_department;
	}

}
