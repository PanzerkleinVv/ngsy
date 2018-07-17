package com.gdin.dzzwsyb.ngsy.web.service;

import java.util.List;

import com.gdin.dzzwsyb.ngsy.core.generic.GenericService;
import com.gdin.dzzwsyb.ngsy.web.model.JobPerson;
import com.gdin.dzzwsyb.ngsy.web.model.JobPersonExtend;
import com.gdin.dzzwsyb.ngsy.web.model.JobUnit;

public interface JobPersonService extends GenericService<JobPerson, String> {
	
	long countXianrenByJobId(String dutiesUnitId);
	
	List<JobPerson> selectPersons(List<JobUnit> jobs);
	
	int updateByPrimaryKey(JobPerson jobPerson);
	
	boolean modify(List<JobPersonExtend> jobs) throws Exception;
	
	List<JobPersonExtend> selectJobsByPersonId(String personId, boolean isXianren);
}
