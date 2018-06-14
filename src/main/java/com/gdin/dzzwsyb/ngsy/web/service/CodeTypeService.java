package com.gdin.dzzwsyb.ngsy.web.service;

import java.util.List;

import com.gdin.dzzwsyb.ngsy.core.generic.GenericService;
import com.gdin.dzzwsyb.ngsy.web.model.CodeType;

/**
 * 用户 业务 接口
 * 
 **/
public interface CodeTypeService extends GenericService<CodeType, String> {

	/**
	 * 按字典项类型名称，模糊查询字典项类型返回结果列表
	 * @param name 查询名称
	 * @return 返回查询结果列表，name为null或空字符串，返回所有字典项类型列表；结果按名称升序
	 */
	List<CodeType> selectList(String name);
}
