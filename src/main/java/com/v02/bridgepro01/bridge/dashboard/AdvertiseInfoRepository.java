package com.v02.bridgepro01.bridge.dashboard;


import com.v02.bridgepro01.bridge.dashboard.vo.AdvertiseInfoVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdvertiseInfoRepository {


     // 광고 정보 조회
     List<AdvertiseInfoVO> SelectAdvertiseInfo();






}
