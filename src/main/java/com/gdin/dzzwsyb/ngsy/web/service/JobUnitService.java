package com.gdin.dzzwsyb.ngsy.web.service;

import java.util.List;

import com.gdin.dzzwsyb.ngsy.core.generic.GenericService;
import com.gdin.dzzwsyb.ngsy.web.model.JobUnit;

public interface JobUnitService extends GenericService<JobUnit, String> {
	
	List<JobUnit> selectList(String unitId);
	
	boolean modify(List<JobUnit> jobs, String unitId) throws Exception;
	
	long countUsedByUnitId(String unitId);
}
