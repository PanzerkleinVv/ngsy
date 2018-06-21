package com.gdin.dzzwsyb.ngsy.web.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gdin.dzzwsyb.ngsy.core.generic.GenericDao;
import com.gdin.dzzwsyb.ngsy.core.generic.GenericServiceImpl;
import com.gdin.dzzwsyb.ngsy.web.dao.UnitMapper;
import com.gdin.dzzwsyb.ngsy.web.model.Unit;
import com.gdin.dzzwsyb.ngsy.web.model.UnitExample;
import com.gdin.dzzwsyb.ngsy.web.service.UnitService;

@Service
public class UnitServiceImpl extends GenericServiceImpl<Unit, String> implements UnitService {
	@Resource
	private UnitMapper unitMapper;

	@Override
	public GenericDao<Unit, String> getDao() {
		return unitMapper;
	}

	@Override
	public List<Unit> findIsUsed() {
		UnitExample unitExample = new UnitExample();
		unitExample.createCriteria().andIsUsedEqualTo(1);
		unitExample.setOrderByClause("sort asc");
		return unitMapper.selectByExample(unitExample);
	}

	@Override
	public Unit selectWithSuperiorNameById(String id) {
		return unitMapper.selectExtendByPrimaryKey(id);
	}

}
