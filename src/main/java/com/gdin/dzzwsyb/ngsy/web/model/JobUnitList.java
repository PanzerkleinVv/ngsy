package com.gdin.dzzwsyb.ngsy.web.model;

import java.util.List;

public class JobUnitList {
	private List<JobUnit> jobUnits;

	public JobUnitList(List<JobUnit> jobUnits) {
		super();
		this.jobUnits = jobUnits;
	}

	public JobUnitList() {
		super();
	}

	public List<JobUnit> getJobUnits() {
		return jobUnits;
	}

	public void setJobUnits(List<JobUnit> jobUnits) {
		this.jobUnits = jobUnits;
	}

}
