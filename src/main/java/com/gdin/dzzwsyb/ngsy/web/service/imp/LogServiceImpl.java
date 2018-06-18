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
public class LogServiceImpl extends GenericServiceImpl<Log, Long> implements LogService {

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
	public int delete(Long id) {
		return logMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Log selectById(Long id) {
		return logMapper.selectByPrimaryKey(id);
	}

	@Override
	public GenericDao<Log, Long> getDao() {
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
		if (logQuery == null || logQuery.getPageNo() == 0) {
			page = new Page<Log>(1);
			example.createCriteria().andIdIsNotNull();
		} else {
			page = new Page<Log>(logQuery.getPageNo());
			Criteria criteria = example.createCriteria();
			logQuery.setExample(criteria);
		}
		example.setOrderByClause("time desc");
		logMapper.selectPage(example, page);
		return page;
	}

	@Override
	public void log(Log log) {
		log.setTime(new Date());
		logMapper.insert(log);
	}
	
}
