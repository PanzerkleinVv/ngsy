package com.gdin.dzzwsyb.ngsy.web.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gdin.dzzwsyb.ngsy.core.generic.GenericDao;
import com.gdin.dzzwsyb.ngsy.core.generic.GenericServiceImpl;
import com.gdin.dzzwsyb.ngsy.core.util.ApplicationUtils;
import com.gdin.dzzwsyb.ngsy.web.dao.JobUnitMapper;
import com.gdin.dzzwsyb.ngsy.web.model.JobUnit;
import com.gdin.dzzwsyb.ngsy.web.model.JobUnitExample;
import com.gdin.dzzwsyb.ngsy.web.service.JobUnitService;

@Service
public class JobUnitServiceImpl extends GenericServiceImpl<JobUnit, String> implements JobUnitService {
	@Resource
	private JobUnitMapper jobUnitMapper;

	@Override
	public GenericDao<JobUnit, String> getDao() {
		return jobUnitMapper;
	}

	@Override
	public List<JobUnit> selectList(String unitId) {
		JobUnitExample example = new JobUnitExample();
		example.createCriteria().andUnitIdEqualTo(unitId);
		example.setOrderByClause("is_used desc, sort asc");
		return jobUnitMapper.selectByExample(example);
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public boolean modify(List<JobUnit> jobs, String unitId) throws Exception {
		JobUnit job = null;
		int flag;
		for (int i = 0; i < jobs.size(); i++) {
			job = jobs.get(i);
			if (job == null || job.isEmpty()) {
				continue;
			} else {
				job.setUnitId(unitId);
				if ("".equals(job.getSalary())) {
					job.setSalary(null);
				}
				if (job.getId() == null || "".equals(job.getId())) {
					job.setId(ApplicationUtils.newUUID());
					flag = jobUnitMapper.insertSelective(job);
				} else {
					flag = jobUnitMapper.updateByPrimaryKeySelective(job);
				}
				if (flag < 1) {
					throw new Exception("更新出错");
				}
			}
		}
		return true;
	}
	
	@Override
	public long countUsedByUnitId(String unitId) {
		JobUnitExample example = new JobUnitExample();
		example.createCriteria().andUnitIdEqualTo(unitId).andIsUsedEqualTo("1");
		return jobUnitMapper.countByExample(example);
	}

}
