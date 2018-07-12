package com.gdin.dzzwsyb.ngsy.web.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gdin.dzzwsyb.ngsy.core.generic.GenericDao;
import com.gdin.dzzwsyb.ngsy.core.generic.GenericServiceImpl;
import com.gdin.dzzwsyb.ngsy.web.dao.PersonMapper;
import com.gdin.dzzwsyb.ngsy.web.model.Person;
import com.gdin.dzzwsyb.ngsy.web.model.PersonExample;
import com.gdin.dzzwsyb.ngsy.web.model.Role;
import com.gdin.dzzwsyb.ngsy.web.service.PersonService;

@Service
public class PersonServiceImpl extends GenericServiceImpl<Person, String> implements PersonService {
	
	@Resource 
	PersonMapper personMapper;
	@Override
	public GenericDao<Person, String> getDao() {
		// TODO Auto-generated method stub
		return personMapper;
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
