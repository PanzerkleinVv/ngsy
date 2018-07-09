package com.gdin.dzzwsyb.ngsy.web.service.imp;

import java.util.List;

import javax.annotation.Resource;

import com.gdin.dzzwsyb.ngsy.core.generic.GenericDao;
import com.gdin.dzzwsyb.ngsy.core.generic.GenericServiceImpl;
import com.gdin.dzzwsyb.ngsy.core.util.ApplicationUtils;
import com.gdin.dzzwsyb.ngsy.web.dao.RankMapper;
import com.gdin.dzzwsyb.ngsy.web.model.Rank;
import com.gdin.dzzwsyb.ngsy.web.model.RankExample;
import com.gdin.dzzwsyb.ngsy.web.service.RankService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户Service实现类
 *
 */
@Service
public class RankServiceImpl extends GenericServiceImpl<Rank, String> implements RankService {

	@Resource
	private RankMapper rankMapper;

	@Override
	public int insert(Rank model) {
		return rankMapper.insertSelective(model);
	}

	@Override
	public int update(Rank model) {
		return rankMapper.updateByPrimaryKeySelective(model);
	}

	@Override
	public int delete(String id) {
		return rankMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Rank selectById(String id) {
		return rankMapper.selectByPrimaryKey(id);
	}

	@Override
	public GenericDao<Rank, String> getDao() {
		return rankMapper;
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public int modify(List<Rank> ranks, String personId) throws Exception {
		int flag = 0;
		for (Rank rank : ranks) {
			if (rank == null) {
				continue;
			}
			int temp = 0;
			rank.setPersonId(personId);
			if (rank.getId() != null && !"".equals(rank.getId())) {
				temp = update(rank);
			} else {
				rank.setId(ApplicationUtils.newUUID());
				temp = insert(rank);
			}
			if (temp < 1) {
				throw new Exception("修改职级出错，操作回滚");
			} else {
				flag += temp;
			}
		}
		return flag;
	}
	
	@Override
	public List<Rank> selectByPersonId(String personId) {
		if (personId != null && !"".equals(personId)) {
			RankExample example = new RankExample();
			example.createCriteria().andPersonIdEqualTo(personId);
			example.setOrderByClause("own_date desc");
			return rankMapper.selectByExample(example);
		}
		return null;
	}

}
