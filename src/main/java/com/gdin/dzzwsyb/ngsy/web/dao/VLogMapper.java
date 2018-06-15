package com.gdin.dzzwsyb.ngsy.web.dao;

import com.gdin.dzzwsyb.ngsy.core.feature.orm.mybatis.Page;
import com.gdin.dzzwsyb.ngsy.core.generic.GenericDao;
import com.gdin.dzzwsyb.ngsy.web.model.VLog;
import com.gdin.dzzwsyb.ngsy.web.model.VLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VLogMapper extends GenericDao<VLog, Long>{
    long countByExample(VLogExample example);

    int deleteByExample(VLogExample example);

    int insert(VLog record);

    int insertSelective(VLog record);

    List<VLog> selectByExample(VLogExample example);
    
    Page<VLog> selectByPage(VLogExample example, Page<VLog> page);

    int updateByExampleSelective(@Param("record") VLog record, @Param("example") VLogExample example);

    int updateByExample(@Param("record") VLog record, @Param("example") VLogExample example);
}