package com.gdin.dzzwsyb.ngsy.web.dao;

import com.gdin.dzzwsyb.ngsy.core.generic.GenericDao;
import com.gdin.dzzwsyb.ngsy.web.model.JobPerson;
import com.gdin.dzzwsyb.ngsy.web.model.JobPersonExample;
import com.gdin.dzzwsyb.ngsy.web.model.JobPersonExtend;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JobPersonMapper extends GenericDao<JobPerson, String> {
	long countByExample(JobPersonExample example);

	int deleteByExample(JobPersonExample example);

	int deleteByPrimaryKey(String id);

	int insert(JobPerson record);

	int insertSelective(JobPerson record);

	List<JobPerson> selectByExample(JobPersonExample example);

	JobPerson selectByPrimaryKey(String id);

	int updateByExampleSelective(@Param("record") JobPerson record, @Param("example") JobPersonExample example);

	int updateByExample(@Param("record") JobPerson record, @Param("example") JobPersonExample example);

	int updateByPrimaryKeySelective(JobPerson record);

	int updateByPrimaryKey(JobPerson record);
	
	List<JobPersonExtend> selectJobsByPersonId(@Param("personId") String personId,
			@Param("isXianren") Boolean isXianren);
}