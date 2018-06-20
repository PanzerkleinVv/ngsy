package com.gdin.dzzwsyb.ngsy.web.service;

import java.util.List;

import com.gdin.dzzwsyb.ngsy.core.generic.GenericService;
import com.gdin.dzzwsyb.ngsy.web.model.Code;
import com.gdin.dzzwsyb.ngsy.web.model.CodeExample;

/**
 * 用户 业务 接口
 * 
 **/
public interface CodeService extends GenericService<Code, String> {
	
	/**
	 * 按字典项类型返回字典项列表
	 * @param type 字典项类型id
	 * @return 返回字典项列表，type为null或空字符串，返回null；结果按代码升序
	 */
	List<Code> selectList(String type);
	
	int deleteByType(String type);
	
	long countByExample(CodeExample example);
	
	List<Code> searchCodeByName(String name);
}
