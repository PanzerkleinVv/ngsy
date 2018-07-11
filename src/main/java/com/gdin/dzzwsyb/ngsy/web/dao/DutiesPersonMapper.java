package com.gdin.dzzwsyb.ngsy.web.dao;

import com.gdin.dzzwsyb.ngsy.core.generic.GenericDao;
import com.gdin.dzzwsyb.ngsy.web.model.DutiesPerson;
import com.gdin.dzzwsyb.ngsy.web.model.DutiesPersonExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DutiesPersonMapper extends GenericDao<DutiesPerson, String> {
	long countByExample(DutiesPersonExample example);

	int deleteByExample(DutiesPersonExample example);

	int deleteByPrimaryKey(String id);

	int insert(DutiesPerson record);

	int insertSelective(DutiesPerson record);

	List<DutiesPerson> selectByExample(DutiesPersonExample example);

	DutiesPerson selectByPrimaryKey(String id);

	int updateByExampleSelective(@Param("record") DutiesPerson record, @Param("example") DutiesPersonExample example);

	int updateByExample(@Param("record") DutiesPerson record, @Param("example") DutiesPersonExample example);

	int updateByPrimaryKeySelective(DutiesPerson record);

	int updateByPrimaryKey(DutiesPerson record);
	
	
	
}