package com.gdin.dzzwsyb.ngsy.web.service;

import java.util.List;

import com.gdin.dzzwsyb.ngsy.core.generic.GenericService;
import com.gdin.dzzwsyb.ngsy.web.model.Education;

/**
 * 用户 业务 接口
 * 
 **/
public interface EducationService extends GenericService<Education, String> {
	int modify(List<Education> educations, String personId) throws Exception;

	List<Education> selectByPersonId(String personId);
}
