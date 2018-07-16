package com.gdin.dzzwsyb.ngsy.web.model;

public class JobPersonExtend extends JobPerson{
	private String personName;
	
	private String jobName;
	
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

	public JobPersonExtend() {};
	
	public JobPersonExtend(JobPerson jobPerson) {
		super(jobPerson);
	}
}
