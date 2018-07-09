package com.gdin.dzzwsyb.ngsy.web.model;

public class DutiesPersonExtend extends DutiesPerson{
	private String personName;
	
	private String dutiesName;
	
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
