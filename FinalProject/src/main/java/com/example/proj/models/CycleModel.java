package com.example.proj.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cycles")
public class CycleModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String year;

	@Column(name = "date_init")
	private LocalDate dateInit;

	@Column(name = "date_end")
	private LocalDate dateEnd;

	@Column(name = "status")
	private String status; // CLOSE, ACTIVE, NEXT

	public CycleModel() {
		super();
	}

	public CycleModel(long id, String year, LocalDate dateInit, LocalDate dateEnd, String status) {
		super();
		this.id = id;
		this.year = year;
		this.dateInit = dateInit;
		this.dateEnd = dateEnd;
		this.status = status;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public LocalDate getDateInit() {
		return dateInit;
	}

	public void setDateInit(LocalDate dateInit) {
		this.dateInit = dateInit;
	}

	public LocalDate getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(LocalDate dateEnd) {
		this.dateEnd = dateEnd;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
