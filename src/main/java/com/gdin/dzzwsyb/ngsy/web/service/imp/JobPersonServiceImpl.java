package com.gdin.dzzwsyb.ngsy.web.service.imp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.gdin.dzzwsyb.ngsy.core.generic.GenericDao;
import com.gdin.dzzwsyb.ngsy.core.generic.GenericServiceImpl;
import com.gdin.dzzwsyb.ngsy.web.dao.JobPersonMapper;
import com.gdin.dzzwsyb.ngsy.web.model.JobPerson;
import com.gdin.dzzwsyb.ngsy.web.model.JobPersonExample;
import com.gdin.dzzwsyb.ngsy.web.model.JobPersonExtend;
import com.gdin.dzzwsyb.ngsy.web.model.JobUnit;
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

	@Override
	public List<JobPerson> selectPersons(List<JobUnit> jobs) {
		List<JobPerson> allPersons = new ArrayList<JobPerson>();
		for(JobUnit jobUnit:jobs) {
			JobPersonExample example = new JobPersonExample();
			example.createCriteria().andJobIdEqualTo(jobUnit.getId()).andLostDateIsNull();
			List<JobPerson> persons = jobPersonMapper.selectByExample(example);
			for(JobPerson jobPerson:persons) {
				allPersons.add(jobPerson);
			}
		}
		Collections.sort(allPersons,new Comparator<JobPerson>(){
				@Override
				public int compare(JobPerson o1, JobPerson o2) {
					return new Integer(o1.getSort()).compareTo(new Integer(o2.getSort()));
				}
	        });
		return allPersons;
	}

	@Override
	public int updateByPrimaryKey(JobPerson jobPerson) {
		return jobPersonMapper.updateByPrimaryKey(jobPerson);
	}

	@Override
	public boolean modify(List<JobPersonExtend> jobs) throws Exception {
		JobPersonExtend jobPersonExtend = null;
		int flag;
		for (int i = 0; i < jobs.size(); i++) {
			jobPersonExtend = jobs.get(i);
			if (jobPersonExtend == null) {
				continue;
			} else {
				JobPerson jobPerson = jobPersonMapper.selectByPrimaryKey(jobPersonExtend.getId());
				jobPerson.setSort(jobPersonExtend.getSort());
				flag = jobPersonMapper.updateByPrimaryKeySelective(jobPerson);
				if (flag < 1) {
					throw new Exception("更新出错");
				}
			}
		}
		return true;
	}

	@Override
	public List<JobPersonExtend> selectJobsByPersonId(String personId, boolean isXianren) {
		return jobPersonMapper.selectJobsByPersonId(personId, isXianren);
	}
}
