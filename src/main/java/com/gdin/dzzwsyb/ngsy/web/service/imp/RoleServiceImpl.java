package com.gdin.dzzwsyb.ngsy.web.service.imp;

import java.util.List;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gdin.dzzwsyb.ngsy.core.generic.GenericDao;
import com.gdin.dzzwsyb.ngsy.core.generic.GenericServiceImpl;
import com.gdin.dzzwsyb.ngsy.web.dao.RoleMapper;
import com.gdin.dzzwsyb.ngsy.web.model.Role;
import com.gdin.dzzwsyb.ngsy.web.model.RoleExample;
import com.gdin.dzzwsyb.ngsy.web.service.RoleService;

/**
 * 角色Service实现类
 *
 * @since 2014年6月10日 下午4:16:33
 */
@Service
public class RoleServiceImpl extends GenericServiceImpl<Role, Long> implements RoleService {

	@Resource
	private RoleMapper roleMapper;

	@Override
	public GenericDao<Role, Long> getDao() {
		return roleMapper;
	}

	@Override
	public List<Role> selectRolesByUserId(Long userId) {
		return roleMapper.selectRolesByUserId(userId);
	}

	@Override
	public List<Role> selectList() {
		final RoleExample example = new RoleExample();
		example.createCriteria().andIdIsNotNull();
		example.setOrderByClause("ID");
		return roleMapper.selectByExample(example);
	}

}
