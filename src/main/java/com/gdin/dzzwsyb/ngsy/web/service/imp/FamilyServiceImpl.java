package com.gdin.dzzwsyb.ngsy.web.service.imp;

import java.util.List;

import javax.annotation.Resource;

import com.gdin.dzzwsyb.ngsy.core.generic.GenericDao;
import com.gdin.dzzwsyb.ngsy.core.generic.GenericServiceImpl;
import com.gdin.dzzwsyb.ngsy.core.util.ApplicationUtils;
import com.gdin.dzzwsyb.ngsy.web.dao.FamilyMapper;
import com.gdin.dzzwsyb.ngsy.web.model.Family;
import com.gdin.dzzwsyb.ngsy.web.model.FamilyExample;
import com.gdin.dzzwsyb.ngsy.web.service.FamilyService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户Service实现类
 *
 */
@Service
public class FamilyServiceImpl extends GenericServiceImpl<Family, String> implements FamilyService {

	@Resource
	private FamilyMapper familyMapper;

	@Override
	public int insert(Family model) {
		return familyMapper.insertSelective(model);
	}

	@Override
	public int update(Family model) {
		return familyMapper.updateByPrimaryKeySelective(model);
	}

	@Override
	public int delete(String id) {
		return familyMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Family selectById(String id) {
		return familyMapper.selectByPrimaryKey(id);
	}

	@Override
	public GenericDao<Family, String> getDao() {
		return familyMapper;
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public int modify(List<Family> families, String personId) throws Exception {
		int flag = 0;
		for (Family family : families) {
			if (family == null) {
				continue;
			}
			int temp = 0;
			family.setPersonId(personId);
			if (family.getId() != null && !"".equals(family.getId())) {
				temp = update(family);
			} else {
				family.setId(ApplicationUtils.newUUID());
				temp = insert(family);
			}
			if (temp < 1) {
				throw new Exception("修改家庭成员信息出错，操作回滚");
			} else {
				flag += temp;
			}
		}
		return flag;
	}
	
	@Override
	public List<Family> selectByPersonId(String personId) {
		if (personId != null && !"".equals(personId)) {
			FamilyExample example = new FamilyExample();
			example.createCriteria().andPersonIdEqualTo(personId);
			example.setOrderByClause("relation asc");
			return familyMapper.selectByExample(example);
		}
		return null;
	}

}
