package com.gdin.dzzwsyb.ngsy.web.model;

public class JobPersonExtend extends JobPerson{
	private String personName;
	
	private String jobName;
	
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

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
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

	public JobPersonExtend() {};
	
	public JobPersonExtend(JobPerson jobPerson) {
		super(jobPerson);
	}
}
