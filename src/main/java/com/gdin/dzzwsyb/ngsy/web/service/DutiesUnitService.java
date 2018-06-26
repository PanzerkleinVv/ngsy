package com.gdin.dzzwsyb.ngsy.web.service;

import java.util.List;

import com.gdin.dzzwsyb.ngsy.core.generic.GenericService;
import com.gdin.dzzwsyb.ngsy.web.model.DutiesUnit;

public interface DutiesUnitService extends GenericService<DutiesUnit, String> {
	
	List<DutiesUnit> selectList(String unitId);
	
	boolean modify(List<DutiesUnit> duties, String unitId) throws Exception;
	
	long countUsedByUnitId(String unitId);
}
