package com.gdin.dzzwsyb.ngsy.web.dao;

import com.gdin.dzzwsyb.ngsy.core.generic.GenericDao;
import com.gdin.dzzwsyb.ngsy.web.model.TechnicalTitle;
import com.gdin.dzzwsyb.ngsy.web.model.TechnicalTitleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TechnicalTitleMapper extends GenericDao<TechnicalTitle, String> {
	long countByExample(TechnicalTitleExample example);

	int deleteByExample(TechnicalTitleExample example);

	int deleteByPrimaryKey(String id);

	int insert(TechnicalTitle record);

	int insertSelective(TechnicalTitle record);

	List<TechnicalTitle> selectByExample(TechnicalTitleExample example);

	TechnicalTitle selectByPrimaryKey(String id);

	int updateByExampleSelective(@Param("record") TechnicalTitle record,
			@Param("example") TechnicalTitleExample example);

	int updateByExample(@Param("record") TechnicalTitle record, @Param("example") TechnicalTitleExample example);

	int updateByPrimaryKeySelective(TechnicalTitle record);

	int updateByPrimaryKey(TechnicalTitle record);
}