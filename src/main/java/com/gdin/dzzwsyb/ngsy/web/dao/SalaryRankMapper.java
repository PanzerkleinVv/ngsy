package com.gdin.dzzwsyb.ngsy.web.dao;

import com.gdin.dzzwsyb.ngsy.core.generic.GenericDao;
import com.gdin.dzzwsyb.ngsy.web.model.SalaryRank;
import com.gdin.dzzwsyb.ngsy.web.model.SalaryRankExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SalaryRankMapper extends GenericDao<SalaryRank, String> {
	long countByExample(SalaryRankExample example);

	int deleteByExample(SalaryRankExample example);

	int deleteByPrimaryKey(String id);

	int insert(SalaryRank record);

	int insertSelective(SalaryRank record);

	List<SalaryRank> selectByExample(SalaryRankExample example);

	SalaryRank selectByPrimaryKey(String id);

	int updateByExampleSelective(@Param("record") SalaryRank record, @Param("example") SalaryRankExample example);

	int updateByExample(@Param("record") SalaryRank record, @Param("example") SalaryRankExample example);

	int updateByPrimaryKeySelective(SalaryRank record);

	int updateByPrimaryKey(SalaryRank record);
}