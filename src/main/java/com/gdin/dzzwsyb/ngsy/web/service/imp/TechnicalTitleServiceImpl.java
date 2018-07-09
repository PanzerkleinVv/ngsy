package com.gdin.dzzwsyb.ngsy.web.service.imp;

import java.util.List;

import javax.annotation.Resource;

import com.gdin.dzzwsyb.ngsy.core.generic.GenericDao;
import com.gdin.dzzwsyb.ngsy.core.generic.GenericServiceImpl;
import com.gdin.dzzwsyb.ngsy.core.util.ApplicationUtils;
import com.gdin.dzzwsyb.ngsy.web.dao.TechnicalTitleMapper;
import com.gdin.dzzwsyb.ngsy.web.model.TechnicalTitle;
import com.gdin.dzzwsyb.ngsy.web.model.TechnicalTitleExample;
import com.gdin.dzzwsyb.ngsy.web.service.TechnicalTitleService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户Service实现类
 *
 */
@Service
public class TechnicalTitleServiceImpl extends GenericServiceImpl<TechnicalTitle, String>
		implements TechnicalTitleService {

	@Resource
	private TechnicalTitleMapper technicalTitleMapper;

	@Override
	public int insert(TechnicalTitle model) {
		return technicalTitleMapper.insertSelective(model);
	}

	@Override
	public int update(TechnicalTitle model) {
		return technicalTitleMapper.updateByPrimaryKeySelective(model);
	}

	@Override
	public int delete(String id) {
		return technicalTitleMapper.deleteByPrimaryKey(id);
	}

	@Override
	public TechnicalTitle selectById(String id) {
		return technicalTitleMapper.selectByPrimaryKey(id);
	}

	@Override
	public GenericDao<TechnicalTitle, String> getDao() {
		return technicalTitleMapper;
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public int modify(List<TechnicalTitle> technicalTitles, String personId) throws Exception {
		int flag = 0;
		for (TechnicalTitle technicalTitle : technicalTitles) {
			if (technicalTitle == null) {
				continue;
			}
			technicalTitle.setPersonId(personId);
			if (technicalTitle.getId() != null && !"".equals(technicalTitle.getId())) {
				flag += update(technicalTitle);
			} else {
				technicalTitle.setId(ApplicationUtils.newUUID());
				flag += insert(technicalTitle);
			}
		}
		if (flag != technicalTitles.size()) {
			throw new Exception("修改职称出错，操作回滚");
		}
		return flag;
	}

	@Override
	public List<TechnicalTitle> selectByPersonId(String personId) {
		if (personId != null && !"".equals(personId)) {
			TechnicalTitleExample example = new TechnicalTitleExample();
			example.createCriteria().andPersonIdEqualTo(personId);
			example.setOrderByClause("own_date asc");
			return technicalTitleMapper.selectByExample(example);
		}
		return null;
	}

}
