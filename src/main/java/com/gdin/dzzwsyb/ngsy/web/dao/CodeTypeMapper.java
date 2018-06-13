package com.gdin.dzzwsyb.ngsy.web.dao;

import com.gdin.dzzwsyb.ngsy.core.generic.GenericDao;
import com.gdin.dzzwsyb.ngsy.web.model.CodeType;
import com.gdin.dzzwsyb.ngsy.web.model.CodeTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CodeTypeMapper extends GenericDao<CodeType, String> {
	long countByExample(CodeTypeExample example);

	int deleteByExample(CodeTypeExample example);

	int deleteByPrimaryKey(String id);

	int insert(CodeType record);

	int insertSelective(CodeType record);

	List<CodeType> selectByExample(CodeTypeExample example);

	CodeType selectByPrimaryKey(String id);

	int updateByExampleSelective(@Param("record") CodeType record, @Param("example") CodeTypeExample example);

	int updateByExample(@Param("record") CodeType record, @Param("example") CodeTypeExample example);

	int updateByPrimaryKeySelective(CodeType record);

	int updateByPrimaryKey(CodeType record);
}