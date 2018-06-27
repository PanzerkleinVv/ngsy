package com.gdin.dzzwsyb.ngsy.web.service.imp;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.gdin.dzzwsyb.ngsy.core.generic.GenericDao;
import com.gdin.dzzwsyb.ngsy.core.generic.GenericServiceImpl;
import com.gdin.dzzwsyb.ngsy.web.dao.DutiesPersonMapper;
import com.gdin.dzzwsyb.ngsy.web.model.DutiesPerson;
import com.gdin.dzzwsyb.ngsy.web.model.DutiesPersonExample;
import com.gdin.dzzwsyb.ngsy.web.service.DutiesPersonService;

@Service
public class DutiesPersonServiceImpl extends GenericServiceImpl<DutiesPerson, String> implements DutiesPersonService {
	@Resource
	private DutiesPersonMapper dutiesPersonMapper;

	@Override
	public GenericDao<DutiesPerson, String> getDao() {
		return dutiesPersonMapper;
	}

	@Override
	public long countXianrenByDutiesId(String dutiesUnitId) {
		DutiesPersonExample example = new DutiesPersonExample();
		example.createCriteria().andDutiesUnitIdEqualTo(dutiesUnitId).andLostDateIsNull();
		return dutiesPersonMapper.countByExample(example);
	}

}
