package com.gdin.dzzwsyb.ngsy.web.service;

import java.util.List;

import com.gdin.dzzwsyb.ngsy.core.generic.GenericService;
import com.gdin.dzzwsyb.ngsy.web.model.Resume;

/**
 * 用户 业务 接口
 * 
 **/
public interface ResumeService extends GenericService<Resume, String> {
	int modify(List<Resume> resumes, String personId) throws Exception;
	
	List<Resume> selectByPersonId(String personId);
}
