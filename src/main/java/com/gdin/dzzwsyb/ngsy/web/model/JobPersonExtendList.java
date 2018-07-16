package com.gdin.dzzwsyb.ngsy.web.model;

import java.util.List;

public class JobPersonExtendList {
	private List<JobPersonExtend> JobPersonExtends;

	public JobPersonExtendList( List<JobPersonExtend> JobPersonExtends) {
		super();
		this.JobPersonExtends = JobPersonExtends;
	}

	public JobPersonExtendList() {
		super();
	}

	public List<JobPersonExtend> getJobPersonExtends() {
		return JobPersonExtends;
	}

	public void setJobPersonExtends(List<JobPersonExtend> jobPersonExtends) {
		JobPersonExtends = jobPersonExtends;
	}

	

}
