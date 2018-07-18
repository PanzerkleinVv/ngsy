package com.gdin.dzzwsyb.ngsy.web.service.imp;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.gdin.dzzwsyb.ngsy.core.feature.orm.mybatis.Page;
import com.gdin.dzzwsyb.ngsy.core.generic.GenericDao;
import com.gdin.dzzwsyb.ngsy.core.generic.GenericServiceImpl;
import com.gdin.dzzwsyb.ngsy.core.util.ApplicationUtils;
import com.gdin.dzzwsyb.ngsy.web.dao.TechnicalTitleMapper;
import com.gdin.dzzwsyb.ngsy.web.model.Person;
import com.gdin.dzzwsyb.ngsy.web.model.PersonExample;
import com.gdin.dzzwsyb.ngsy.web.model.TechnicalTitle;
import com.gdin.dzzwsyb.ngsy.web.model.TechnicalTitleExample;
import com.gdin.dzzwsyb.ngsy.web.model.PersonExample.Criteria;
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
			int temp = 0;
			technicalTitle.setPersonId(personId);
			if (technicalTitle.getId() != null && !"".equals(technicalTitle.getId())) {
				temp = update(technicalTitle);
			} else {
				technicalTitle.setId(ApplicationUtils.newUUID());
				temp = insert(technicalTitle);
			}
			if (temp < 1) {
				throw new Exception("修改职称出错，操作回滚");
			} else {
				flag += temp;
			}
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

	@Override
	public List<Person> check(List<Person> persons, String technicalTitle) {
		// TODO Auto-generated method stub
		List<Person> personList = new ArrayList<Person>();
		for(Person person : persons) {
			TechnicalTitleExample example = new TechnicalTitleExample();
			example.createCriteria().andPersonIdEqualTo(person.getId()).andTechnicalTitleEqualTo(technicalTitle);
			List<TechnicalTitle> technicalTitles = technicalTitleMapper.selectByExample(example);
			if(technicalTitles.size()>0) {
				personList.add(person);
			}
		}
		return personList;
	}

	@Override
	public Page<TechnicalTitle> selectPage(List<Person> personsList, Integer pageNo,String technicalTitle) {
		// TODO Auto-generated method stub
		List<String> personId = new ArrayList<String>();
		Page<TechnicalTitle> page = null;
		TechnicalTitleExample example = new TechnicalTitleExample();
		if(personsList != null || personsList.size()>0) {
			for(Person person : personsList) {
				personId.add(person.getId());
			}
		}
		if(personId != null || personId.size()>0) {
			page = new Page<TechnicalTitle>(pageNo);
			example.createCriteria().andPersonIdIn(personId).andTechnicalTitleEqualTo(technicalTitle);
			example.setOrderByClause("id asc");
		}
		technicalTitleMapper.selectPage(example, page);
		return page;
	}

}
