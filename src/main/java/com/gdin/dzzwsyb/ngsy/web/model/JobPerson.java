package com.gdin.dzzwsyb.ngsy.web.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class JobPerson {
	private String id;

	private String personId;

	private String jobId;

	private String shuangJianTiao;

	private String jobSalary;

	private Long salary;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ownDate;

	private String isProbation;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date probationDate;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date lostDate;
	
	private int sort;
	
	public JobPerson() {};
	
	public JobPerson(JobPerson jobPerson) {
		id = jobPerson.getId();
		personId = jobPerson.getPersonId();
		jobId = jobPerson.getJobId();
		shuangJianTiao = jobPerson.getShuangJianTiao();
		salary = jobPerson.getSalary();
		ownDate = jobPerson.getOwnDate();
		isProbation = jobPerson.getIsProbation();
		probationDate = jobPerson.getProbationDate();
		lostDate = jobPerson.getLostDate();
		sort = jobPerson.getSort();
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

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

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId == null ? null : jobId.trim();
	}

	public String getShuangJianTiao() {
		return shuangJianTiao;
	}

	public void setShuangJianTiao(String shuangJianTiao) {
		this.shuangJianTiao = shuangJianTiao == null ? null : shuangJianTiao.trim();
	}

	public String getJobSalary() {
		return jobSalary;
	}

	public void setJobSalary(String jobSalary) {
		this.jobSalary = jobSalary == null ? null : jobSalary.trim();
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}

	public Date getOwnDate() {
		return ownDate;
	}

	public void setOwnDate(Date ownDate) {
		this.ownDate = ownDate;
	}

	public String getIsProbation() {
		return isProbation;
	}

	public void setIsProbation(String isProbation) {
		this.isProbation = isProbation == null ? null : isProbation.trim();
	}

	public Date getProbationDate() {
		return probationDate;
	}

	public void setProbationDate(Date probationDate) {
		this.probationDate = probationDate;
	}

	public Date getLostDate() {
		return lostDate;
	}

	public void setLostDate(Date lostDate) {
		this.lostDate = lostDate;
	}
}