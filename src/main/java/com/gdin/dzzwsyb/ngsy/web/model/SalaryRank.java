package com.gdin.dzzwsyb.ngsy.web.model;

public class SalaryRank {
	private String id;

	private String rank;

	private String standard;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank == null ? null : rank.trim();
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard == null ? null : standard.trim();
	}
}