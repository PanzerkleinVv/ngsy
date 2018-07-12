package com.gdin.dzzwsyb.ngsy.web.dao;

import com.gdin.dzzwsyb.ngsy.core.feature.orm.mybatis.Page;
import com.gdin.dzzwsyb.ngsy.core.generic.GenericDao;
import com.gdin.dzzwsyb.ngsy.web.model.Person;
import com.gdin.dzzwsyb.ngsy.web.model.PersonExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PersonMapper extends GenericDao<Person, String> {
	long countByExample(PersonExample example);

	int deleteByExample(PersonExample example);

	int deleteByPrimaryKey(String id);

	int insert(Person record);

	int insertSelective(Person record);

	List<Person> selectByExample(PersonExample example);

	Person selectByPrimaryKey(String id);

	int updateByExampleSelective(@Param("record") Person record, @Param("example") PersonExample example);

	int updateByExample(@Param("record") Person record, @Param("example") PersonExample example);

	int updateByPrimaryKeySelective(Person record);

	int updateByPrimaryKey(Person record);
	
	List<Person> selectPage(PersonExample example, Page<Person> page);
}