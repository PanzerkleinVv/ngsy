package com.gdin.dzzwsyb.ngsy.web.dao;

import com.gdin.dzzwsyb.ngsy.core.generic.GenericDao;
import com.gdin.dzzwsyb.ngsy.web.model.Unit;
import com.gdin.dzzwsyb.ngsy.web.model.UnitExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UnitMapper extends GenericDao<Unit, String> {
	long countByExample(UnitExample example);

	int deleteByExample(UnitExample example);

	int deleteByPrimaryKey(String id);

	int insert(Unit record);

	int insertSelective(Unit record);

	List<Unit> selectByExample(UnitExample example);

	Unit selectByPrimaryKey(String id);
	
	Unit selectExtendByPrimaryKey(String id);

	int updateByExampleSelective(@Param("record") Unit record, @Param("example") UnitExample example);

	int updateByExample(@Param("record") Unit record, @Param("example") UnitExample example);

	int updateByPrimaryKeySelective(Unit record);

	int updateByPrimaryKey(Unit record);
}