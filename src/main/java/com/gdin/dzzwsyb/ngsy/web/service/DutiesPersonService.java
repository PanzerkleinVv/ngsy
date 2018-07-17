package com.gdin.dzzwsyb.ngsy.web.service;



import java.util.List;

import com.gdin.dzzwsyb.ngsy.core.generic.GenericService;
import com.gdin.dzzwsyb.ngsy.web.model.DutiesPerson;
import com.gdin.dzzwsyb.ngsy.web.model.DutiesPersonExtend;
import com.gdin.dzzwsyb.ngsy.web.model.DutiesUnit;
import com.gdin.dzzwsyb.ngsy.web.model.JobPersonExtend;

public interface DutiesPersonService extends GenericService<DutiesPerson, String> {
	
	long countXianrenByDutiesId(String jobUnitId);
	
	List<DutiesPerson> selectPersons(List<DutiesUnit> duties);
	
	boolean modify(List<DutiesPersonExtend> duties) throws Exception;
	
	int updateByPrimaryKey(DutiesPerson dutiesPerson);
	
	List<DutiesPersonExtend> selectDutiesByPersonId(String personId, boolean isXianren);
	
}
