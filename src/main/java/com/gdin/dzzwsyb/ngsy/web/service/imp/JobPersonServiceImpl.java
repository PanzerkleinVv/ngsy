package com.gdin.dzzwsyb.ngsy.web.service.imp;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.gdin.dzzwsyb.ngsy.core.generic.GenericDao;
import com.gdin.dzzwsyb.ngsy.core.generic.GenericServiceImpl;
import com.gdin.dzzwsyb.ngsy.web.dao.JobPersonMapper;
import com.gdin.dzzwsyb.ngsy.web.model.JobPerson;
import com.gdin.dzzwsyb.ngsy.web.model.JobPersonExample;
import com.gdin.dzzwsyb.ngsy.web.service.JobPersonService;

@Service
public class JobPersonServiceImpl extends GenericServiceImpl<JobPerson, String> implements JobPersonService {
	@Resource
	private JobPersonMapper jobPersonMapper;

	@Override
	public GenericDao<JobPerson, String> getDao() {
		return jobPersonMapper;
	}

	@Override
	public long countXianrenByJobId(String jobUnitId) {
		JobPersonExample example = new JobPersonExample();
		example.createCriteria().andJobIdEqualTo(jobUnitId).andLostDateIsNull();
		return jobPersonMapper.countByExample(example);
	}

}
