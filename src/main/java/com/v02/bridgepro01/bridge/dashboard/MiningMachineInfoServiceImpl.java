package com.v02.bridgepro01.bridge.dashboard;

import com.v02.bridgepro01.bridge.dashboard.vo.MiningMachineInfoVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MiningMachineInfoServiceImpl implements MiningMachineInfoService {

    private final MiningMachineInfoRepository miningMachineInfoRepository;
    @Override
    public List<MiningMachineInfoVO> SelectMiningMachineInfo() {
        return miningMachineInfoRepository.SelectMiningMachineInfo();
    }
}
