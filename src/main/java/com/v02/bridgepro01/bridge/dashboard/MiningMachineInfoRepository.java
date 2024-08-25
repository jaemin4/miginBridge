package com.v02.bridgepro01.bridge.dashboard;

import com.v02.bridgepro01.bridge.dashboard.vo.MiningMachineInfoVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MiningMachineInfoRepository {

    List<MiningMachineInfoVO> SelectMiningMachineInfo();
}
