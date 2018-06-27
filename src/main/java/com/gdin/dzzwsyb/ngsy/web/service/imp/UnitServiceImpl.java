package com.gdin.dzzwsyb.ngsy.web.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

	@Override
	public int getMaxSort(String superiorId) {
		final Integer max = unitMapper.selectMaxSortBySuperiorId(superiorId);
		if (max == null) {
			return 0;
		} else {
			return max;
		}
	}

	@Override
	public List<Unit> getSortList(String id) {
		final UnitExample example = new UnitExample();
		example.createCriteria().andIsUsedEqualTo(1)
				.addCriterion("superior_id = (select superior_id from unit where id = '" + id + "')");
		example.setOrderByClause("sort asc");
		return unitMapper.selectByExample(example);
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public int updateSort(String[] ids) throws Exception {
		int flag = 0;
		Unit unit = null;
		if (ids != null) {
			for (int i = 0; i < ids.length; i++) {
				unit = new Unit();
				unit.setSort(i);
				unit.setId(ids[i]);
				flag = unitMapper.updateByPrimaryKeySelective(unit);
				if (flag < 1) {
					throw new Exception("保存栏目排序出错");
				}
			}
			flag = ids.length;
		} else {
			flag = 0;
		}
		return flag;
	}

}
