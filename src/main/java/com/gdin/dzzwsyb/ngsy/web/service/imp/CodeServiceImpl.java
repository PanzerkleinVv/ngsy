package com.gdin.dzzwsyb.ngsy.web.service.imp;

import java.util.List;
import javax.annotation.Resource;

import com.gdin.dzzwsyb.ngsy.core.generic.GenericDao;
import com.gdin.dzzwsyb.ngsy.core.generic.GenericServiceImpl;
import com.gdin.dzzwsyb.ngsy.web.dao.CodeMapper;
import com.gdin.dzzwsyb.ngsy.web.model.Code;
import com.gdin.dzzwsyb.ngsy.web.model.CodeExample;
import com.gdin.dzzwsyb.ngsy.web.service.CodeService;
import org.springframework.stereotype.Service;

/**
 * 用户Service实现类
 *
 */
@Service
public class CodeServiceImpl extends GenericServiceImpl<Code, String> implements CodeService {

	@Resource
	private CodeMapper codeMapper;

	@Override
	public int insert(Code model) {
		return codeMapper.insertSelective(model);
	}

	@Override
	public int update(Code model) {
		return codeMapper.updateByPrimaryKeySelective(model);
	}

	@Override
	public int delete(String id) {
		return codeMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Code selectById(String id) {
		return codeMapper.selectByPrimaryKey(id);
	}

	@Override
	public GenericDao<Code, String> getDao() {
		return codeMapper;
	}

	@Override
	public List<Code> selectList() {
		CodeExample example = new CodeExample();
		example.createCriteria().andIdIsNotNull();
		example.setOrderByClause("code");
		return codeMapper.selectByExample(example);
	}

	@Override
	public List<Code> selectList(String type) {
		if (type != null && !"".equals(type)) {
			CodeExample example = new CodeExample();
			example.createCriteria().andTypeEqualTo(type);
			example.setOrderByClause("code asc");
			return codeMapper.selectByExample(example);
		} else {
			return null;
		}
	}

	@Override
	public int deleteByType(String type) {
		CodeExample example = new CodeExample();
		example.createCriteria().andTypeEqualTo(type);
		return codeMapper.deleteByExample(example);
	}

	@Override
	public long countByExample(CodeExample example) {
		// TODO Auto-generated method stub
		return codeMapper.countByExample(example);
	}

	@Override
	public List<Code> searchCodeByName(String name) {
		// TODO Auto-generated method stub
		Code record = new Code();
		record.setName(name);
		record.setId("0cbded8f58422ce1ada36a4429081cd84850bff5");
		return codeMapper.searchCodeByName(record);
	}
	
}
