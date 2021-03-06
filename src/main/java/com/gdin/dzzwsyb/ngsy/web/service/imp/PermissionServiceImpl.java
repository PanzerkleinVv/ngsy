package com.gdin.dzzwsyb.ngsy.web.service.imp;

import java.util.List;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gdin.dzzwsyb.ngsy.core.generic.GenericDao;
import com.gdin.dzzwsyb.ngsy.core.generic.GenericServiceImpl;
import com.gdin.dzzwsyb.ngsy.web.dao.PermissionMapper;
import com.gdin.dzzwsyb.ngsy.web.model.Permission;
import com.gdin.dzzwsyb.ngsy.web.model.PermissionExample;
import com.gdin.dzzwsyb.ngsy.web.service.PermissionService;

/**
 * 权限Service实现类
 *
 * @since 2014年6月10日 下午12:05:03
 */
@Service
public class PermissionServiceImpl extends GenericServiceImpl<Permission, Long> implements PermissionService {

	@Resource
	private PermissionMapper permissionMapper;

	@Override
	public GenericDao<Permission, Long> getDao() {
		return permissionMapper;
	}

	@Override
	public List<Permission> selectPermissionsByUserId(Long userId) {
		return permissionMapper.selectPermissionsByUserId(userId);
	}
	
	public List<Permission> selectList() {
		PermissionExample example = new PermissionExample();
		example.createCriteria().andIdIsNotNull();
		example.setOrderByClause("ID");
		return permissionMapper.selectByExample(example);
	}
}
