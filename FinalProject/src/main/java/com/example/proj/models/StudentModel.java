package com.example.proj.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public class StudentModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String firstName;
	private String lastName;

	@ManyToOne
	@JoinColumn(name = "campus_id")
	private CampusModel campus;

	@ManyToOne
	@JoinColumn(name = "level_id")
	private CatCampusLevel campusLevel;

	@ManyToOne
	@JoinColumn(name = "grade_id")
	private CatCampusGrades campusGrade;

	private String groupChar;

	private boolean active;

	public StudentModel() {
		super();
	}

	public StudentModel(long id, String firstName, String lastName, CampusModel campus, CatCampusLevel campusLevel,
			CatCampusGrades campusGrade, String groupChar, boolean active) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.campus = campus;
		this.campusLevel = campusLevel;
		this.campusGrade = campusGrade;
		this.groupChar = groupChar;
		this.active = active;
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

	public CampusModel getCampus() {
		return campus;
	}

	public void setCampus(CampusModel campus) {
		this.campus = campus;
	}

	public CatCampusLevel getCampusLevel() {
		return campusLevel;
	}

	public void setCampusLevel(CatCampusLevel campusLevel) {
		this.campusLevel = campusLevel;
	}

	public CatCampusGrades getCampusGrade() {
		return campusGrade;
	}

	public void setCampusGrade(CatCampusGrades campusGrade) {
		this.campusGrade = campusGrade;
	}

	public String getGroupChar() {
		return groupChar;
	}

	public void setGroupChar(String groupChar) {
		this.groupChar = groupChar;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
