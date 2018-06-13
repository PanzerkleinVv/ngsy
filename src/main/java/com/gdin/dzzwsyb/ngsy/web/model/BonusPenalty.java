package com.gdin.dzzwsyb.ngsy.web.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class BonusPenalty {
	private String id;

	private String personId;

	private String type;

	private String name;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ownDate;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date lostDate;

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type == null ? null : type.trim();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public Date getOwnDate() {
		return ownDate;
	}

	public void setOwnDate(Date ownDate) {
		this.ownDate = ownDate;
	}

	public Date getLostDate() {
		return lostDate;
	}

	public void setLostDate(Date lostDate) {
		this.lostDate = lostDate;
	}
}