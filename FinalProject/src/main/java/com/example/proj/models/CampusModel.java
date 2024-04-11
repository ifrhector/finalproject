package com.example.proj.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "campus")
public class CampusModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String name;

	@Column(name = "campus_key")
	private String campusKey;

	@Column(name = "register_date")
	private LocalDate regDate;

	@ManyToOne
	@JoinColumn(name = "cycle_id")
	CycleModel cycle;

	public CampusModel() {
		super();
	}

	public CampusModel(long id, String name, String campusKey, LocalDate regDate,
			CycleModel cycle) {
		super();
		this.id = id;
		this.name = name;
		this.campusKey = campusKey;
		this.regDate = regDate;
		this.cycle = cycle;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCampusKey() {
		return campusKey;
	}

	public void setCampusKey(String campusKey) {
		this.campusKey = campusKey;
	}

	public LocalDate getRegDate() {
		return regDate;
	}

	public void setRegDate(LocalDate regDate) {
		this.regDate = regDate;
	}

	public CycleModel getCycle() {
		return cycle;
	}

	public void setCycle(CycleModel cycle) {
		this.cycle = cycle;
	}

}
