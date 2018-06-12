package com.gdin.dzzwsyb.ngsy.web.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.gdin.dzzwsyb.ngsy.core.generic.GenericDao;
import com.gdin.dzzwsyb.ngsy.web.model.Permission;
import com.gdin.dzzwsyb.ngsy.web.model.PermissionExample;

/**
 * 职务表DAO接口
 * 
 * @author PanzerkleinVv
 *
 */
public interface PermissionMapper extends GenericDao<Permission, Long> {
	long countByExample(PermissionExample example);

	int deleteByExample(PermissionExample example);

	int deleteByPrimaryKey(Long id);

	int insert(Permission record);

	int insertSelective(Permission record);

	List<Permission> selectByExample(PermissionExample example);

	Permission selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") Permission record, @Param("example") PermissionExample example);

	int updateByExample(@Param("record") Permission record, @Param("example") PermissionExample example);

	int updateByPrimaryKeySelective(Permission record);

	int updateByPrimaryKey(Permission record);

	/**
	 * ͨ���û�id ��ѯ��ɫ ӵ�е�Ȩ��
	 * 
	 * @param roleId
	 * @return
	 */
	List<Permission> selectPermissionsByUserId(Long userId);
}