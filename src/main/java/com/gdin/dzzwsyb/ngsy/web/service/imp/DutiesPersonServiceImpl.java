package com.gdin.dzzwsyb.ngsy.web.service.imp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gdin.dzzwsyb.ngsy.core.generic.GenericDao;
import com.gdin.dzzwsyb.ngsy.core.generic.GenericServiceImpl;
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
			
			List<DutiesPerson> persons = dutiesPersonMapper.selectByExample(example);
			for(DutiesPerson dutiesPerson:persons) {
				allPersons.add(dutiesPerson);
			}
		}
		Collections.sort(allPersons,new Comparator<DutiesPerson>(){
				@Override
				public int compare(DutiesPerson o1, DutiesPerson o2) {
					// TODO Auto-generated method stub
					return new Integer(o1.getSort()).compareTo(new Integer(o2.getSort()));
				}
	        });
		return allPersons;
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public boolean modify(List<DutiesPersonExtend> duties) throws Exception {
		DutiesPersonExtend dutiesPersonExtend = null;
		int flag;
		for (int i = 0; i < duties.size(); i++) {
			dutiesPersonExtend = duties.get(i);
			if (dutiesPersonExtend == null) {
				continue;
			} else {
				DutiesPerson dutiesPerson = dutiesPersonMapper.selectByPrimaryKey(dutiesPersonExtend.getId());
				dutiesPerson.setSort(dutiesPersonExtend.getSort());
				flag = dutiesPersonMapper.updateByPrimaryKeySelective(dutiesPerson);
				if (flag < 1) {
					throw new Exception("更新出错");
				}
			}
		}
		return true;
	}

	@Override
	public int updateByPrimaryKey(DutiesPerson dutiesPerson) {
		// TODO Auto-generated method stub
		return dutiesPersonMapper.updateByPrimaryKey(dutiesPerson);
	}



}
