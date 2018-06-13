package com.gdin.dzzwsyb.ngsy.web.dao;

import com.gdin.dzzwsyb.ngsy.core.generic.GenericDao;
import com.gdin.dzzwsyb.ngsy.web.model.Resume;
import com.gdin.dzzwsyb.ngsy.web.model.ResumeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ResumeMapper extends GenericDao<Resume, String> {
	long countByExample(ResumeExample example);

	int deleteByExample(ResumeExample example);

	int deleteByPrimaryKey(String id);

	int insert(Resume record);

	int insertSelective(Resume record);

	List<Resume> selectByExample(ResumeExample example);

	Resume selectByPrimaryKey(String id);

	int updateByExampleSelective(@Param("record") Resume record, @Param("example") ResumeExample example);

	int updateByExample(@Param("record") Resume record, @Param("example") ResumeExample example);

	int updateByPrimaryKeySelective(Resume record);

	int updateByPrimaryKey(Resume record);
}