package com.gdin.dzzwsyb.ngsy.web.service.imp;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;

import com.gdin.dzzwsyb.ngsy.core.feature.orm.mybatis.Page;
import com.gdin.dzzwsyb.ngsy.core.generic.GenericDao;
import com.gdin.dzzwsyb.ngsy.core.generic.GenericServiceImpl;
import com.gdin.dzzwsyb.ngsy.web.dao.LogMapper;
import com.gdin.dzzwsyb.ngsy.web.model.Log;
import com.gdin.dzzwsyb.ngsy.web.model.LogExample;
import com.gdin.dzzwsyb.ngsy.web.model.LogExample.Criteria;
import com.gdin.dzzwsyb.ngsy.web.model.LogQuery;
import com.gdin.dzzwsyb.ngsy.web.service.LogService;
import org.springframework.stereotype.Service;

/**
 * 用户Service实现类
 *
 */
@Service
public class LogServiceImpl extends GenericServiceImpl<Log, String> implements LogService {

	@Resource
	private LogMapper logMapper;

	@Override
	public int insert(Log model) {
		return logMapper.insertSelective(model);
	}

	@Override
	public int update(Log model) {
		return logMapper.updateByPrimaryKeySelective(model);
	}

	@Override
	public int delete(String id) {
		return logMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Log selectById(String id) {
		return logMapper.selectByPrimaryKey(id);
	}

	@Override
	public GenericDao<Log, String> getDao() {
		return logMapper;
	}

	@Override
	public List<Log> selectList() {
		LogExample example = new LogExample();
		example.createCriteria().andIdIsNotNull();
		example.setOrderByClause("time desc");
		return logMapper.selectByExample(example);
	}

	@Override
	public Page<Log> selectPage(LogQuery logQuery) {
		Page<Log> page = null;
		LogExample example = new LogExample();
		if (logQuery == null) {
			page = new Page<Log>(1);
			example.createCriteria().andIdIsNotNull();
		} else {
			page = new Page<Log>(logQuery.getPageNo());
			Criteria criteria = example.createCriteria();
			logQuery.setExample(criteria);
		}
		example.setOrderByClause("time desc");
		return logMapper.selectPage(example, page);
	}

	@Override
	public void log(Log log) {
		log.setTime(new Date());
		logMapper.insert(log);
	}
	
}
