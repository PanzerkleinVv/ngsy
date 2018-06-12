package com.gdin.dzzwsyb.ngsy.web.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.gdin.dzzwsyb.ngsy.core.feature.orm.mybatis.Page;
import com.gdin.dzzwsyb.ngsy.core.generic.GenericDao;
import com.gdin.dzzwsyb.ngsy.web.model.User;
import com.gdin.dzzwsyb.ngsy.web.model.UserExample;

/**
 * 用户表DAO接口
 * 
 * @author PanzerkleinVv
 *
 */
public interface UserMapper extends GenericDao<User, Long> {
	long countByExample(UserExample example);

	int deleteByExample(UserExample example);

	int deleteByPrimaryKey(Long id);

	int insert(User record);

	int insertSelective(User record);

	List<User> selectByExample(UserExample example);

	User selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

	int updateByExample(@Param("record") User record, @Param("example") UserExample example);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);

	/**
	 * 用户验证
	 * 
	 * @param record
	 * @return
	 */
	User authentication(@Param("record") User record);

	/**
	 * 根据用户名查询用户
	 * 
	 * @param page
	 * @param example
	 * @return
	 */
	List<User> selectByExampleAndPage(Page<User> page, UserExample example);
}