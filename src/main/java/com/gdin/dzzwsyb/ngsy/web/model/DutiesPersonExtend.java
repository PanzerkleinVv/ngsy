package com.gdin.dzzwsyb.ngsy.web.model;

public class DutiesPersonExtend extends DutiesPerson{
	private String personName;
	
	private String dutiesName;
	
	private String ownDateStr;
	
	private String probationDateStr;
	
	public String getOwnDateStr() {
		return ownDateStr;
	}

	public void setOwnDateStr(String ownDateStr) {
		this.ownDateStr = ownDateStr;
	}

	

	public String getProbationDateStr() {
		return probationDateStr;
	}

	public void setProbationDateStr(String probationDateStr) {
		this.probationDateStr = probationDateStr;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getDutiesName() {
		return dutiesName;
	}

	public void setDutiesName(String dutiesName) {
		this.dutiesName = dutiesName;
	}

	public DutiesPersonExtend() {
		
	}
	
	public DutiesPersonExtend (DutiesPerson dutiesPerson) {
		super(dutiesPerson);
	}
	

}
