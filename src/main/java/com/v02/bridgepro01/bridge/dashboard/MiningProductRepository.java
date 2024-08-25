package com.v02.bridgepro01.bridge.dashboard;

import com.v02.bridgepro01.bridge.dashboard.vo.MiningProductVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MiningProductRepository {

    List<MiningProductVO> SelectMiningProductInfo();

    MiningProductVO SelectByIdMiningProductInfo(String id);

    List<MiningProductVO> SelectWithPaging(@Param("pageSize") int pageSize,@Param("offset") int offset);

    int CountAllMiningProduct();

}
