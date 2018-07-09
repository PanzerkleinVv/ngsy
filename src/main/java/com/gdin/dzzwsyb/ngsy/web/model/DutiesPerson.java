package com.gdin.dzzwsyb.ngsy.web.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class DutiesPerson {
	private String id;

	private String personId;

	private String dutiesUnitId;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ownDate;

	private String isProbation;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date probationDate;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date lostDate;
	
	private int sort;

	public DutiesPerson() {}
	
	public DutiesPerson(DutiesPerson dutiesPerson) {
		// TODO Auto-generated constructor stub
		id = dutiesPerson.getId();
		personId = dutiesPerson.getPersonId();
		dutiesUnitId = dutiesPerson.getDutiesUnitId();
		ownDate = dutiesPerson.getOwnDate();
		isProbation = dutiesPerson.getIsProbation();
		probationDate = dutiesPerson.getProbationDate();
		lostDate = dutiesPerson.getLostDate();
		sort = dutiesPerson.getSort();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId == null ? null : personId.trim();
	}

	public String getDutiesUnitId() {
		return dutiesUnitId;
	}

	public void setDutiesUnitId(String dutiesUnitId) {
		this.dutiesUnitId = dutiesUnitId == null ? null : dutiesUnitId.trim();
	}

	public Date getOwnDate() {
		return ownDate;
	}

	public void setOwnDate(Date ownDate) {
		this.ownDate = ownDate;
	}

	public String getIsProbation() {
		return isProbation;
	}

	public void setIsProbation(String isProbation) {
		this.isProbation = isProbation == null ? null : isProbation.trim();
	}

	public Date getProbationDate() {
		return probationDate;
	}

	public void setProbationDate(Date probationDate) {
		this.probationDate = probationDate;
	}

	public Date getLostDate() {
		return lostDate;
	}

	public void setLostDate(Date lostDate) {
		this.lostDate = lostDate;
	}
	
	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}
}