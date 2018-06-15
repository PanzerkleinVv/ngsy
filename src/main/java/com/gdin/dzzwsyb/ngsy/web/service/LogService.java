package com.gdin.dzzwsyb.ngsy.web.service;

import com.gdin.dzzwsyb.ngsy.core.feature.orm.mybatis.Page;
import com.gdin.dzzwsyb.ngsy.core.generic.GenericService;
import com.gdin.dzzwsyb.ngsy.web.model.Log;
import com.gdin.dzzwsyb.ngsy.web.model.LogQuery;
import com.gdin.dzzwsyb.ngsy.web.model.VLog;

/**
 * 用户 业务 接口
 * 
 **/
public interface LogService extends GenericService<Log, Long> {
	
	/**
	 * 日志分页查询
	 * @param logQuery 传入封装的查询参数和页码
	 * @return 返回分页查询结果，如果logQuery为空，返回查询全表的第一页；按日志时间降序
	 */
	Page<VLog> selectPage(LogQuery logQuery);
	
	/**
	 * 插入日志记录
	 * @param log 日志内容
	 */
	void log(Log log);
}
