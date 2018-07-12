package com.gdin.dzzwsyb.ngsy.web.service;

import java.util.List;

import com.gdin.dzzwsyb.ngsy.core.generic.GenericService;
import com.gdin.dzzwsyb.ngsy.web.model.TechnicalTitle;

/**
 * 用户 业务 接口
 * 
 **/
public interface TechnicalTitleService extends GenericService<TechnicalTitle, String> {
	int modify(List<TechnicalTitle> technicalTitles, String personId) throws Exception;
	
	List<TechnicalTitle> selectByPersonId(String personId);
}
