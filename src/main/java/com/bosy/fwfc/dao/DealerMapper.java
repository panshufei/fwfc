package com.bosy.fwfc.dao;

import com.bosy.fwfc.bean.Dealer;
import com.bosy.fwfc.bean.DealerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DealerMapper {
    long countByExample(DealerExample example);

    int deleteByExample(DealerExample example);

    int deleteByPrimaryKey(Integer dealerId);

    int insert(Dealer record);

    int insertSelective(Dealer record);

    List<Dealer> selectByExample(DealerExample example);

    Dealer selectByPrimaryKey(Integer dealerId);

    int updateByExampleSelective(@Param("record") Dealer record, @Param("example") DealerExample example);

    int updateByExample(@Param("record") Dealer record, @Param("example") DealerExample example);

    int updateByPrimaryKeySelective(Dealer record);

    int updateByPrimaryKey(Dealer record);
}