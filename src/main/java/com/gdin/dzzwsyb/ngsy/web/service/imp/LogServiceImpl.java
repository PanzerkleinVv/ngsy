package com.gdin.dzzwsyb.ngsy.web.service.imp;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;

import com.gdin.dzzwsyb.ngsy.core.feature.orm.mybatis.Page;
import com.gdin.dzzwsyb.ngsy.core.generic.GenericDao;
import com.gdin.dzzwsyb.ngsy.core.generic.GenericServiceImpl;
import com.gdin.dzzwsyb.ngsy.web.dao.LogMapper;
import com.gdin.dzzwsyb.ngsy.web.dao.VLogMapper;
import com.gdin.dzzwsyb.ngsy.web.model.Log;
import com.gdin.dzzwsyb.ngsy.web.model.LogExample;
import com.gdin.dzzwsyb.ngsy.web.model.VLogExample.Criteria;
import com.gdin.dzzwsyb.ngsy.web.model.LogQuery;
import com.gdin.dzzwsyb.ngsy.web.model.VLog;
import com.gdin.dzzwsyb.ngsy.web.model.VLogExample;
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
	@Resource
	private VLogMapper vLogMapper;

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
	public Page<VLog> selectPage(LogQuery logQuery) {
		Page<VLog> page = null;
		VLogExample example = new VLogExample();
		if (logQuery == null) {
			page = new Page<VLog>(1);
			example.createCriteria().andIdIsNotNull();
		} else {
			page = new Page<VLog>(logQuery.getPageNo());
			Criteria criteria = example.createCriteria();
			logQuery.setExample(criteria);
		}
		example.setOrderByClause("time desc");
		return vLogMapper.selectByPage(example, page);
	}

	@Override
	public void log(Log log) {
		log.setTime(new Date());
		logMapper.insert(log);
	}
	
}
