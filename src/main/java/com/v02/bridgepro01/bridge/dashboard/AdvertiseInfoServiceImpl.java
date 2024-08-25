package com.v02.bridgepro01.bridge.dashboard;


import com.v02.bridgepro01.bridge.dashboard.vo.AdvertiseInfoVO;
import com.v02.bridgepro01.bridge.common.status.TraceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdvertiseInfoServiceImpl implements AdvertiseInfoService {

    private final AdvertiseInfoRepository advertiseInfoRepository;
    private final TraceV1 trace;

    @Override
    public List<AdvertiseInfoVO> SelectAdvertiseInfo() {
        return advertiseInfoRepository.SelectAdvertiseInfo();
    }
}
