package com.gdin.dzzwsyb.ngsy.web.service;

import java.util.List;

import com.gdin.dzzwsyb.ngsy.core.generic.GenericService;
import com.gdin.dzzwsyb.ngsy.web.model.Unit;

public interface UnitService extends GenericService<Unit, String> {
	List<Unit> findIsUsed();

	Unit selectWithSuperiorNameById(String id);
	
	int getMaxSort(String superiorId);
	
	List<Unit> getSortList(String superiorId);
	
	int updateSort(String[] ids) throws Exception;
}
