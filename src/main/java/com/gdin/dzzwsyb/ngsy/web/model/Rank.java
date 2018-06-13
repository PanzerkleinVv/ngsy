package com.gdin.dzzwsyb.ngsy.web.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Rank {
	private String id;

	private String personId;

	private String rank;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ownDate;

	private String state;

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

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank == null ? null : rank.trim();
	}

	public Date getOwnDate() {
		return ownDate;
	}

	public void setOwnDate(Date ownDate) {
		this.ownDate = ownDate;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state == null ? null : state.trim();
	}
}