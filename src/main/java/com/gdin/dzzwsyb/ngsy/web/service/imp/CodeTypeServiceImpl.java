package com.gdin.dzzwsyb.ngsy.web.service.imp;

import java.util.List;
import javax.annotation.Resource;

import com.gdin.dzzwsyb.ngsy.core.generic.GenericDao;
import com.gdin.dzzwsyb.ngsy.core.generic.GenericServiceImpl;
import com.gdin.dzzwsyb.ngsy.web.dao.CodeTypeMapper;
import com.gdin.dzzwsyb.ngsy.web.model.CodeType;
import com.gdin.dzzwsyb.ngsy.web.model.CodeTypeExample;
import com.gdin.dzzwsyb.ngsy.web.service.CodeTypeService;

import org.springframework.stereotype.Service;

/**
 * 用户Service实现类
 *
 */
@Service
public class CodeTypeServiceImpl extends GenericServiceImpl<CodeType, String> implements CodeTypeService {

	@Resource
	private CodeTypeMapper codeTypeMapper;

	@Override
	public int insert(CodeType model) {
		return codeTypeMapper.insertSelective(model);
	}

	@Override
	public int update(CodeType model) {
		return codeTypeMapper.updateByPrimaryKeySelective(model);
	}

	@Override
	public int delete(String id) {
		return codeTypeMapper.deleteByPrimaryKey(id);
	}

	@Override
	public CodeType selectById(String id) {
		return codeTypeMapper.selectByPrimaryKey(id);
	}

	@Override
	public GenericDao<CodeType, String> getDao() {
		return codeTypeMapper;
	}

	@Override
	public List<CodeType> selectList() {
		CodeTypeExample example = new CodeTypeExample();
		example.createCriteria().andIdIsNotNull();
		example.setOrderByClause("name");
		return codeTypeMapper.selectByExample(example);
	}

	@Override
	public List<CodeType> selectList(String name) {
		name = (name == null ? "" : name);
		CodeTypeExample example = new CodeTypeExample();
		example.createCriteria().andNameLike("%" + name + "%");
		example.setOrderByClause("name");
		return codeTypeMapper.selectByExample(example);
	}
	
}
