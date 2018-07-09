package com.gdin.dzzwsyb.ngsy.web.dao;

import com.gdin.dzzwsyb.ngsy.core.generic.GenericDao;
import com.gdin.dzzwsyb.ngsy.web.model.Family;
import com.gdin.dzzwsyb.ngsy.web.model.FamilyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FamilyMapper extends GenericDao<Family, String> {
	long countByExample(FamilyExample example);

	int deleteByExample(FamilyExample example);

	int deleteByPrimaryKey(String id);

	int insert(Family record);

	int insertSelective(Family record);

	List<Family> selectByExample(FamilyExample example);

	Family selectByPrimaryKey(String id);

	int updateByExampleSelective(@Param("record") Family record, @Param("example") FamilyExample example);

	int updateByExample(@Param("record") Family record, @Param("example") FamilyExample example);

	int updateByPrimaryKeySelective(Family record);

	int updateByPrimaryKey(Family record);
}