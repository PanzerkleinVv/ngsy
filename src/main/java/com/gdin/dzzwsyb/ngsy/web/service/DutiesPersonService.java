package com.gdin.dzzwsyb.ngsy.web.service;

import com.gdin.dzzwsyb.ngsy.core.generic.GenericService;
import com.gdin.dzzwsyb.ngsy.web.model.DutiesPerson;

public interface DutiesPersonService extends GenericService<DutiesPerson, String> {
	
	long countXianrenByDutiesId(String jobUnitId);
}
