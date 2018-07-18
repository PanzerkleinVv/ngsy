package com.gdin.dzzwsyb.ngsy.web.service.imp;


import javax.annotation.Resource;

import com.gdin.dzzwsyb.ngsy.core.feature.orm.mybatis.Page;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Case;
import org.springframework.stereotype.Service;

import com.gdin.dzzwsyb.ngsy.core.generic.GenericDao;
import com.gdin.dzzwsyb.ngsy.core.generic.GenericServiceImpl;
import com.gdin.dzzwsyb.ngsy.web.dao.PersonMapper;
import com.gdin.dzzwsyb.ngsy.web.model.PeopleExtends;
import com.gdin.dzzwsyb.ngsy.web.model.Person;
import com.gdin.dzzwsyb.ngsy.web.model.PersonExample;
import com.gdin.dzzwsyb.ngsy.web.model.PersonExample.Criteria;
import com.gdin.dzzwsyb.ngsy.web.service.PersonService;
import com.mysql.fabric.xmlrpc.base.Data;

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
	public Page<Person> selectPage(PeopleExtends peopleExtends, Integer pageNo) {
		Page<Person> page = null;
		PersonExample example = new PersonExample();
		Criteria criteria = example.createCriteria();
		if(peopleExtends != null) {
			page = new Page<Person>(pageNo);
			if(!("").equals(peopleExtends.getName()) )
				criteria.andNameLike("%" + peopleExtends.getName() + "%");
			if(!peopleExtends.getEnterDateSelect().equals("") && !("").equals(peopleExtends.getEnterDateInt())) {
				Calendar curr = Calendar.getInstance();
				curr.set(Calendar.YEAR,curr.get(Calendar.YEAR)-Integer.parseInt(peopleExtends.getEnterDateInt()));
				Date date=curr.getTime();
				switch(peopleExtends.getEnterDateSelect()){
				 	case "等于":
				 		criteria.andEnterDateEqualTo(date);
				 		break;
				 	case "大于":
				 		criteria.andEnterDateGreaterThan(date);
				 		break;
				 	case "小于":
				 		criteria.andEnterDateLessThan(date);
				 		break;
				 } 
			}
			if(!peopleExtends.getAgeSelect().equals("") && !("").equals(peopleExtends.getAgeInt())) {
				Calendar curr = Calendar.getInstance();
				curr.set(Calendar.YEAR,curr.get(Calendar.YEAR)-Integer.parseInt(peopleExtends.getAgeInt()));
				Date date=curr.getTime();
				switch(peopleExtends.getAgeSelect()){
			 	case "等于":
			 		criteria.andBirthdayEqualTo(date);
			 		break;
			 	case "大于":
			 		criteria.andBirthdayLessThan(date);
			 		break;
			 	case "小于":
			 		criteria.andBirthdayGreaterThan(date);
			 		break;
			 } 
			}
		}
		else {
			page = new Page<Person>(pageNo);
			criteria.andIdIsNotNull();
		} 
		example.setOrderByClause("id asc");
		personMapper.selectPage(example, page);
		return page;
	}

	@Override
	public List<Person> selectPersonsByName(String personName) {
		// TODO Auto-generated method stub
		PersonExample personExample = new PersonExample();
		personExample.createCriteria().andNameEqualTo(personName);
		List<Person> persons = personMapper.selectByExample(personExample);
		return persons;
	}

}
