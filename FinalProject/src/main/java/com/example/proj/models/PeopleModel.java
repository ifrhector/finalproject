package com.example.proj.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "people")
public class PeopleModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String firstName;
	private String lastName;

	@ManyToOne
	@JoinColumn(name = "campus_id")
	private CampusModel campus;

	@ManyToOne
	@JoinColumn(name = "people_type_id")
	CatPeopleType peopleType;
	
	private boolean active;

	public PeopleModel() {
		super();
	}

	public PeopleModel(long id, String firstName, String lastName, boolean active, CampusModel campus,
			CatPeopleType peopleType) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.active = active;
		this.campus = campus;
		this.peopleType = peopleType;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public CampusModel getCampus() {
		return campus;
	}

	public void setCampus(CampusModel campus) {
		this.campus = campus;
	}

	public CatPeopleType getPeopleType() {
		return peopleType;
	}

	public void setPeopleType(CatPeopleType peopleType) {
		this.peopleType = peopleType;
	}

	
}
