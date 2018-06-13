package com.gdin.dzzwsyb.ngsy.web.dao;

import com.gdin.dzzwsyb.ngsy.core.generic.GenericDao;
import com.gdin.dzzwsyb.ngsy.web.model.BonusPenalty;
import com.gdin.dzzwsyb.ngsy.web.model.BonusPenaltyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BonusPenaltyMapper extends GenericDao<BonusPenalty, String> {
	long countByExample(BonusPenaltyExample example);

	int deleteByExample(BonusPenaltyExample example);

	int deleteByPrimaryKey(String id);

	int insert(BonusPenalty record);

	int insertSelective(BonusPenalty record);

	List<BonusPenalty> selectByExample(BonusPenaltyExample example);

	BonusPenalty selectByPrimaryKey(String id);

	int updateByExampleSelective(@Param("record") BonusPenalty record, @Param("example") BonusPenaltyExample example);

	int updateByExample(@Param("record") BonusPenalty record, @Param("example") BonusPenaltyExample example);

	int updateByPrimaryKeySelective(BonusPenalty record);

	int updateByPrimaryKey(BonusPenalty record);
}