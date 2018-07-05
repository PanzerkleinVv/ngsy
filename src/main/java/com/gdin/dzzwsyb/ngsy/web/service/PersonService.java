package com.gdin.dzzwsyb.ngsy.web.service;

import com.gdin.dzzwsyb.ngsy.core.generic.GenericService;
import com.gdin.dzzwsyb.ngsy.web.model.Person;

/**
 * 用户 业务 接口
 * 
 **/
public interface PersonService extends GenericService<Person, String> {
	long checkIdCard(Person person);
}
