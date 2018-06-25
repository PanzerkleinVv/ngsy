package com.gdin.dzzwsyb.ngsy.web.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gdin.dzzwsyb.ngsy.core.generic.GenericDao;
import com.gdin.dzzwsyb.ngsy.core.generic.GenericServiceImpl;
import com.gdin.dzzwsyb.ngsy.core.util.ApplicationUtils;
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
		example.setOrderByClause("is_used desc, sort asc");
		return dutiesUnitMapper.selectByExample(example);
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public boolean modify(List<DutiesUnit> duties, String unitId) throws Exception {
		DutiesUnit duty = null;
		int flag;
		for (int i = 0; i < duties.size(); i++) {
			duty = duties.get(i);
			if (duty.getId() == null || "".equals(duty.getId())) {
				duty.setId(ApplicationUtils.newUUID());
				duty.setSort(i);
				flag = dutiesUnitMapper.insertSelective(duty);
			} else {
				duty.setSort(i);
				flag = dutiesUnitMapper.updateByPrimaryKeySelective(duty);
			}
			if (flag < 1) {
				throw new Exception("更新出错");
			}
		}
		return true;
	}

}
