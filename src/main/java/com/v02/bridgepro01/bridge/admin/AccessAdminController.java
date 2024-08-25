package com.v02.bridgepro01.bridge.admin;

import com.v02.bridgepro01.bridge.dashboard.vo.AdvertiseInfoVO;
import com.v02.bridgepro01.bridge.common.status.ControllerFunc;
import com.v02.bridgepro01.bridge.dashboard.AdvertiseInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor

public class AccessAdminController {

    private final AdvertiseInfoService advertiseInfoService;
    ControllerFunc controllerFunc = new ControllerFunc();

    @GetMapping("/admin")
    public ResponseEntity<Map<String, Object>> getAdvertiseInfo() {
        List<AdvertiseInfoVO> listVO = advertiseInfoService.SelectAdvertiseInfo();
        return controllerFunc.selectAll(listVO, "payload");
    }
}
