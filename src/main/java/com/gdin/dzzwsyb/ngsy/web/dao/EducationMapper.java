package com.gdin.dzzwsyb.ngsy.web.dao;

import com.gdin.dzzwsyb.ngsy.core.generic.GenericDao;
import com.gdin.dzzwsyb.ngsy.web.model.Education;
import com.gdin.dzzwsyb.ngsy.web.model.EducationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EducationMapper extends GenericDao<Education, String> {
	long countByExample(EducationExample example);

	int deleteByExample(EducationExample example);

	int deleteByPrimaryKey(String id);

	int insert(Education record);

	int insertSelective(Education record);

	List<Education> selectByExample(EducationExample example);

	Education selectByPrimaryKey(String id);

	int updateByExampleSelective(@Param("record") Education record, @Param("example") EducationExample example);

	int updateByExample(@Param("record") Education record, @Param("example") EducationExample example);

	int updateByPrimaryKeySelective(Education record);

	int updateByPrimaryKey(Education record);
}