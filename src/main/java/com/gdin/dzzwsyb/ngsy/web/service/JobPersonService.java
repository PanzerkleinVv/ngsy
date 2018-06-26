package com.gdin.dzzwsyb.ngsy.web.service;

import com.gdin.dzzwsyb.ngsy.core.generic.GenericService;
import com.gdin.dzzwsyb.ngsy.web.model.JobPerson;

public interface JobPersonService extends GenericService<JobPerson, String> {
	
	long countXianrenByJobId(String dutiesUnitId);
}
