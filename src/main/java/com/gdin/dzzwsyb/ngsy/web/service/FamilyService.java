package com.gdin.dzzwsyb.ngsy.web.service;

import java.util.List;

import com.gdin.dzzwsyb.ngsy.core.generic.GenericService;
import com.gdin.dzzwsyb.ngsy.web.model.Family;

/**
 * 用户 业务 接口
 * 
 **/
public interface FamilyService extends GenericService<Family, String> {
	int modify(List<Family> families, String personId) throws Exception;

	List<Family> selectByPersonId(String personId);
}
