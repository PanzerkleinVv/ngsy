package com.gdin.dzzwsyb.ngsy.web.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.gdin.dzzwsyb.ngsy.core.generic.GenericDao;
import com.gdin.dzzwsyb.ngsy.web.model.Role;
import com.gdin.dzzwsyb.ngsy.web.model.RoleExample;

/**
 * 处室表DAO接口
 * 
 * @author PanzerkleinVv
 *
 */
public interface RoleMapper extends GenericDao<Role, Long> {
	long countByExample(RoleExample example);

	int deleteByExample(RoleExample example);

	int deleteByPrimaryKey(Long id);

	int insert(Role record);

	int insertSelective(Role record);

	List<Role> selectByExample(RoleExample example);

	Role selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleExample example);

	int updateByExample(@Param("record") Role record, @Param("example") RoleExample example);

	int updateByPrimaryKeySelective(Role record);

	int updateByPrimaryKey(Role record);

	/**
	 * ͨ���û�id ��ѯ�û� ӵ�еĽ�ɫ
	 * 
	 * @param id
	 * @return
	 */
	List<Role> selectRolesByUserId(Long userId);
}