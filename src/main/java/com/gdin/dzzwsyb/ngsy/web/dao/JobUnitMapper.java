package com.gdin.dzzwsyb.ngsy.web.dao;

import com.gdin.dzzwsyb.ngsy.core.generic.GenericDao;
import com.gdin.dzzwsyb.ngsy.web.model.JobUnit;
import com.gdin.dzzwsyb.ngsy.web.model.JobUnitExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JobUnitMapper extends GenericDao<JobUnit, String> {
	long countByExample(JobUnitExample example);

	int deleteByExample(JobUnitExample example);

	int deleteByPrimaryKey(String id);

	int insert(JobUnit record);

	int insertSelective(JobUnit record);

	List<JobUnit> selectByExample(JobUnitExample example);

	JobUnit selectByPrimaryKey(String id);

	int updateByExampleSelective(@Param("record") JobUnit record, @Param("example") JobUnitExample example);

	int updateByExample(@Param("record") JobUnit record, @Param("example") JobUnitExample example);

	int updateByPrimaryKeySelective(JobUnit record);

	int updateByPrimaryKey(JobUnit record);
}