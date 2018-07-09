package com.gdin.dzzwsyb.ngsy.web.service.imp;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gdin.dzzwsyb.ngsy.core.generic.GenericDao;
import com.gdin.dzzwsyb.ngsy.core.generic.GenericServiceImpl;
import com.gdin.dzzwsyb.ngsy.core.util.ApplicationUtils;
import com.gdin.dzzwsyb.ngsy.web.dao.DutiesPersonMapper;
import com.gdin.dzzwsyb.ngsy.web.model.DutiesPerson;
import com.gdin.dzzwsyb.ngsy.web.model.DutiesPersonExample;
import com.gdin.dzzwsyb.ngsy.web.model.DutiesPersonExtend;
import com.gdin.dzzwsyb.ngsy.web.model.DutiesUnit;
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

	@Override
	public List<DutiesPerson> selectPersons(List<DutiesUnit> duties) {
		// TODO Auto-generated method stub
		List<DutiesPerson> allPersons = new ArrayList<DutiesPerson>();
		for(DutiesUnit dutiesUnit:duties) {
			DutiesPersonExample example = new DutiesPersonExample();
			example.createCriteria().andDutiesUnitIdEqualTo(dutiesUnit.getId()).andLostDateIsNull();
			List<DutiesPerson> persons = dutiesPersonMapper.selectPersons(example);
			for(DutiesPerson dutiesPerson:persons) {
				allPersons.add(dutiesPerson);
			}
		}
		return allPersons;
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public boolean modify(List<DutiesPerson> duties, String unitId) throws Exception {
		DutiesPerson dutiesPerson = null;
		int flag;
		for (int i = 0; i < duties.size(); i++) {
			dutiesPerson = duties.get(i);
			if (dutiesPerson == null) {
				continue;
			} else {
				flag = dutiesPersonMapper.updateByPrimaryKeySelective(dutiesPerson);
				if (flag < 1) {
					throw new Exception("更新出错");
				}
			}
		}
		return true;
	}

}
