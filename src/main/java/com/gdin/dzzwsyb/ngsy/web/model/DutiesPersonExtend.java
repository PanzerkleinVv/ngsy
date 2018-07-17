package com.gdin.dzzwsyb.ngsy.web.model;

public class DutiesPersonExtend extends DutiesPerson{
	private String personName;
	
	private String dutiesName;
	
	private String unitName;
	
	private String unitId;
	
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

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getUnitId() {
		return unitId;
	}

	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}

	public DutiesPersonExtend() {
		
	}
	
	public DutiesPersonExtend (DutiesPerson dutiesPerson) {
		super(dutiesPerson);
	}
	

}
