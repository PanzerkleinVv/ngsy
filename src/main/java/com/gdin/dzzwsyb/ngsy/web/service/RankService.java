package com.gdin.dzzwsyb.ngsy.web.service;

import java.util.List;

import com.gdin.dzzwsyb.ngsy.core.generic.GenericService;
import com.gdin.dzzwsyb.ngsy.web.model.Rank;

/**
 * 用户 业务 接口
 * 
 **/
public interface RankService extends GenericService<Rank, String> {
	int modify(List<Rank> ranks, String personId) throws Exception;

	List<Rank> selectByPersonId(String personId);
}
