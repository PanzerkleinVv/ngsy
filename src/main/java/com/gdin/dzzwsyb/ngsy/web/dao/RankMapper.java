package com.gdin.dzzwsyb.ngsy.web.dao;

import com.gdin.dzzwsyb.ngsy.core.generic.GenericDao;
import com.gdin.dzzwsyb.ngsy.web.model.Rank;
import com.gdin.dzzwsyb.ngsy.web.model.RankExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RankMapper extends GenericDao<Rank, String> {
	long countByExample(RankExample example);

	int deleteByExample(RankExample example);

	int deleteByPrimaryKey(String id);

	int insert(Rank record);

	int insertSelective(Rank record);

	List<Rank> selectByExample(RankExample example);

	Rank selectByPrimaryKey(String id);

	int updateByExampleSelective(@Param("record") Rank record, @Param("example") RankExample example);

	int updateByExample(@Param("record") Rank record, @Param("example") RankExample example);

	int updateByPrimaryKeySelective(Rank record);

	int updateByPrimaryKey(Rank record);
}