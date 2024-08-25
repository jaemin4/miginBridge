package com.v02.bridgepro01.bridge.dashboard;


import com.v02.bridgepro01.bridge.dashboard.vo.MiningProductVO;

import java.util.List;

public interface MiningProductService {

    List<MiningProductVO> SelectMiningProductInfo();

    MiningProductVO SelectByIdProductInfo(String id);

    List<MiningProductVO> SelectWithPaging(int pageSize,int offset);

    int CountAllMiningProduct();


}
