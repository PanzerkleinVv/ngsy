package com.gdin.dzzwsyb.ngsy.web.dao;

import com.gdin.dzzwsyb.ngsy.core.generic.GenericDao;
import com.gdin.dzzwsyb.ngsy.web.model.Ndkh;
import com.gdin.dzzwsyb.ngsy.web.model.NdkhExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NdkhMapper extends GenericDao<Ndkh, String> {
	long countByExample(NdkhExample example);

	int deleteByExample(NdkhExample example);

	int deleteByPrimaryKey(String id);

	int insert(Ndkh record);

	int insertSelective(Ndkh record);

	List<Ndkh> selectByExample(NdkhExample example);

	Ndkh selectByPrimaryKey(String id);

	int updateByExampleSelective(@Param("record") Ndkh record, @Param("example") NdkhExample example);

	int updateByExample(@Param("record") Ndkh record, @Param("example") NdkhExample example);

	int updateByPrimaryKeySelective(Ndkh record);

	int updateByPrimaryKey(Ndkh record);
}