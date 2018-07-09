package com.gdin.dzzwsyb.ngsy.web.service.imp;

import java.util.List;

import javax.annotation.Resource;

import com.gdin.dzzwsyb.ngsy.core.generic.GenericDao;
import com.gdin.dzzwsyb.ngsy.core.generic.GenericServiceImpl;
import com.gdin.dzzwsyb.ngsy.core.util.ApplicationUtils;
import com.gdin.dzzwsyb.ngsy.web.dao.EducationMapper;
import com.gdin.dzzwsyb.ngsy.web.model.Education;
import com.gdin.dzzwsyb.ngsy.web.model.EducationExample;
import com.gdin.dzzwsyb.ngsy.web.service.EducationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户Service实现类
 *
 */
@Service
public class EducationServiceImpl extends GenericServiceImpl<Education, String> implements EducationService {

	@Resource
	private EducationMapper educationMapper;

	@Override
	public int insert(Education model) {
		return educationMapper.insertSelective(model);
	}

	@Override
	public int update(Education model) {
		return educationMapper.updateByPrimaryKeySelective(model);
	}

	@Override
	public int delete(String id) {
		return educationMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Education selectById(String id) {
		return educationMapper.selectByPrimaryKey(id);
	}

	@Override
	public GenericDao<Education, String> getDao() {
		return educationMapper;
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public int modify(List<Education> educations, String personId) throws Exception {
		int flag = 0;
		for (Education education : educations) {
			if (education == null) {
				continue;
			}
			education.setPersonId(personId);
			if (education.getId() != null && !"".equals(education.getId())) {
				flag += update(education);
			} else {
				education.setId(ApplicationUtils.newUUID());
				flag += insert(education);
			}
		}
		if (flag != educations.size()) {
			throw new Exception("修改教育信息出错，操作回滚");
		}
		return flag;
	}
	
	@Override
	public List<Education> selectByPersonId(String personId) {
		if (personId != null && !"".equals(personId)) {
			EducationExample example = new EducationExample();
			example.createCriteria().andPersonIdEqualTo(personId);
			example.setOrderByClause("graduation_date desc");
			return educationMapper.selectByExample(example);
		}
		return null;
	}

}
