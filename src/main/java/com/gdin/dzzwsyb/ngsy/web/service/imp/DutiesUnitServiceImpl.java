package com.gdin.dzzwsyb.ngsy.web.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.gdin.dzzwsyb.ngsy.core.generic.GenericDao;
import com.gdin.dzzwsyb.ngsy.core.generic.GenericServiceImpl;
import com.gdin.dzzwsyb.ngsy.web.dao.DutiesUnitMapper;
import com.gdin.dzzwsyb.ngsy.web.model.DutiesUnit;
import com.gdin.dzzwsyb.ngsy.web.model.DutiesUnitExample;
import com.gdin.dzzwsyb.ngsy.web.service.DutiesUnitService;

@Service
public class DutiesUnitServiceImpl extends GenericServiceImpl<DutiesUnit, String> implements DutiesUnitService {
	@Resource
	private DutiesUnitMapper dutiesUnitMapper;

	@Override
	public GenericDao<DutiesUnit, String> getDao() {
		return dutiesUnitMapper;
	}

	@Override
	public List<DutiesUnit> selectList(String unitId) {
		DutiesUnitExample example = new DutiesUnitExample();
		example.createCriteria().andUnitIdEqualTo(unitId);
		example.setOrderByClause("sort asc");
		return dutiesUnitMapper.selectByExample(example);
	}

}
