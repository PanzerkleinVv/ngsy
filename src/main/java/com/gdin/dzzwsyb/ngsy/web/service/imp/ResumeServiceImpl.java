package com.gdin.dzzwsyb.ngsy.web.service.imp;

import java.util.List;

import javax.annotation.Resource;

import com.gdin.dzzwsyb.ngsy.core.generic.GenericDao;
import com.gdin.dzzwsyb.ngsy.core.generic.GenericServiceImpl;
import com.gdin.dzzwsyb.ngsy.core.util.ApplicationUtils;
import com.gdin.dzzwsyb.ngsy.web.dao.ResumeMapper;
import com.gdin.dzzwsyb.ngsy.web.model.Resume;
import com.gdin.dzzwsyb.ngsy.web.model.ResumeExample;
import com.gdin.dzzwsyb.ngsy.web.service.ResumeService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户Service实现类
 *
 */
@Service
public class ResumeServiceImpl extends GenericServiceImpl<Resume, String> implements ResumeService {

	@Resource
	private ResumeMapper resumeMapper;

	@Override
	public int insert(Resume model) {
		return resumeMapper.insertSelective(model);
	}

	@Override
	public int update(Resume model) {
		return resumeMapper.updateByPrimaryKeySelective(model);
	}

	@Override
	public int delete(String id) {
		return resumeMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Resume selectById(String id) {
		return resumeMapper.selectByPrimaryKey(id);
	}

	@Override
	public GenericDao<Resume, String> getDao() {
		return resumeMapper;
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public int modify(List<Resume> resumes, String personId) throws Exception {
		int flag = 0;
		for (Resume resume : resumes) {
			resume.setPersonId(personId);
			if (resume.getId() != null && !"".equals(resume.getId())) {
				flag += update(resume);
			} else {
				resume.setId(ApplicationUtils.newUUID());
				flag += insert(resume);
			}
		}
		if (flag != resumes.size()) {
			throw new Exception("修改简介出错，操作回滚");
		}
		return flag;
	}
	
	@Override
	public List<Resume> selectByPersonId(String personId) {
		if (personId != null && !"".equals(personId)) {
			ResumeExample example = new ResumeExample();
			example.createCriteria().andPersonIdEqualTo(personId);
			example.setOrderByClause("beginDate asc");
			return resumeMapper.selectByExample(example);
		}
		return null;
	}

}
