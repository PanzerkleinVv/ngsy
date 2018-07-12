package com.gdin.dzzwsyb.ngsy.web.service.imp;

import javax.annotation.Resource;

import com.gdin.dzzwsyb.ngsy.core.feature.orm.mybatis.Page;
import com.gdin.dzzwsyb.ngsy.core.generic.GenericDao;
import com.gdin.dzzwsyb.ngsy.core.generic.GenericServiceImpl;
import com.gdin.dzzwsyb.ngsy.web.dao.PersonMapper;
import com.gdin.dzzwsyb.ngsy.web.model.Person;
import com.gdin.dzzwsyb.ngsy.web.model.PersonExample;
import com.gdin.dzzwsyb.ngsy.web.service.PersonService;

import org.springframework.stereotype.Service;

/**
 * 用户Service实现类
 *
 */
@Service
public class PersonServiceImpl extends GenericServiceImpl<Person, String> implements PersonService {

	@Resource
	private PersonMapper personMapper;

	@Override
	public int insert(Person model) {
		return personMapper.insertSelective(model);
	}

	@Override
	public int update(Person model) {
		return personMapper.updateByPrimaryKeySelective(model);
	}

	@Override
	public int delete(String id) {
		return personMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Person selectById(String id) {
		return personMapper.selectByPrimaryKey(id);
	}

	@Override
	public GenericDao<Person, String> getDao() {
		return personMapper;
	}

	@Override
	public long checkIdCard(Person person) {
		if (person != null) {
			PersonExample example = new PersonExample();
			if (person.getId() == null || "".equals(person.getId())) {
				example.createCriteria().andIdCardEqualTo(person.getIdCard());
			} else {
				example.createCriteria().andIdCardEqualTo(person.getIdCard()).andIdNotEqualTo(person.getId());
			}
			return personMapper.countByExample(example);
		} else {
			return 1L;
		}
	}

	@Override
	public Page<Person> selectPage(Person person, Integer pageNo) {
		Page<Person> page = null;
		PersonExample example = new PersonExample();
		if (person == null || person.getName() == null) {
			page = new Page<Person>(pageNo);
			example.createCriteria().andIdIsNotNull();
		} else {
			page = new Page<Person>(pageNo);
			example.createCriteria().andNameLike("%" + person.getName() + "%");
		}
		example.setOrderByClause("id asc");
		personMapper.selectPage(example, page);
		return page;
	}

}
