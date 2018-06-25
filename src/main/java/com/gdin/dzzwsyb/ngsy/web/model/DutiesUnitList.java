package com.gdin.dzzwsyb.ngsy.web.model;

import java.util.List;

public class DutiesUnitList {
	private List<DutiesUnit> dutieUnits;

	public DutiesUnitList(List<DutiesUnit> dutieUnits) {
		super();
		this.dutieUnits = dutieUnits;
	}

	public DutiesUnitList() {
		super();
	}

	public List<DutiesUnit> getDutieUnits() {
		return dutieUnits;
	}

	public void setDutieUnits(List<DutiesUnit> dutieUnits) {
		this.dutieUnits = dutieUnits;
	}

}
