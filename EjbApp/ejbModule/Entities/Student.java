package Entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Student  extends User implements Serializable{

	private String firstName;
	private String lastName;
	private String telephone;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "filiere_id", referencedColumnName = "id")
	private Filiere filiere;
	
	public Student() {
		super();

	}

	public Student(String firstName, String lastName, String telephone) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.telephone = telephone;
	}

	public Filiere getFiliere() {
		return filiere;
	}


	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

}
