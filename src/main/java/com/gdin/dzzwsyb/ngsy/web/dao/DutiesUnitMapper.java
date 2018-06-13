package com.gdin.dzzwsyb.ngsy.web.dao;

import com.gdin.dzzwsyb.ngsy.core.generic.GenericDao;
import com.gdin.dzzwsyb.ngsy.web.model.DutiesUnit;
import com.gdin.dzzwsyb.ngsy.web.model.DutiesUnitExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DutiesUnitMapper extends GenericDao<DutiesUnit, String> {
	long countByExample(DutiesUnitExample example);

	int deleteByExample(DutiesUnitExample example);

	int deleteByPrimaryKey(String id);

	int insert(DutiesUnit record);

	int insertSelective(DutiesUnit record);

	List<DutiesUnit> selectByExample(DutiesUnitExample example);

	DutiesUnit selectByPrimaryKey(String id);

	int updateByExampleSelective(@Param("record") DutiesUnit record, @Param("example") DutiesUnitExample example);

	int updateByExample(@Param("record") DutiesUnit record, @Param("example") DutiesUnitExample example);

	int updateByPrimaryKeySelective(DutiesUnit record);

	int updateByPrimaryKey(DutiesUnit record);
}