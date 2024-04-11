package com.example.proj.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cat_campus_grades")
public class CatCampusGrades {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String gradeName;

	private String shortName;

	public CatCampusGrades() {
		super();
	}

	public CatCampusGrades(long id, String gradeName, String shortName) {
		super();
		this.id = id;
		this.gradeName = gradeName;
		this.shortName = shortName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getGradeName() {
		return gradeName;
	}

	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

}
