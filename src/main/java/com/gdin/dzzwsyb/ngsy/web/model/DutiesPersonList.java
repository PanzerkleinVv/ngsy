package com.gdin.dzzwsyb.ngsy.web.model;

import java.util.List;

public class DutiesPersonList {
	private List<DutiesPerson> DutiesPersons;

	public DutiesPersonList(List<DutiesPerson> DutiesPersons) {
		super();
		this.DutiesPersons = DutiesPersons;
	}

	public DutiesPersonList() {
		super();
	}

	public List<DutiesPerson> getDutiesPersons() {
		return DutiesPersons;
	}

	public void setDutiesPersons(List<DutiesPerson> dutiesPersons) {
		DutiesPersons = dutiesPersons;
	}

	
	

}
