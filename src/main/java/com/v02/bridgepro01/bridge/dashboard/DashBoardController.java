package com.v02.bridgepro01.bridge.dashboard;


import com.v02.bridgepro01.bridge.common.status.PagingCulDTO;
import com.v02.bridgepro01.bridge.dashboard.vo.AdvertiseInfoVO;
import com.v02.bridgepro01.bridge.dashboard.vo.MiningMachineInfoVO;
import com.v02.bridgepro01.bridge.dashboard.vo.MiningProductVO;
import com.v02.bridgepro01.bridge.common.status.ControllerFunc;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/dashboard")
public class DashBoardController {

    private final AdvertiseInfoService advertiseInfoService;
    private final MiningMachineInfoService miningMachineInfoService;
    private final MiningProductService miningProductService;
    ControllerFunc controllerFunc = new ControllerFunc();


    //광고 정보 전체조회
    @GetMapping("/ad/info/get")
    public ResponseEntity<Map<String, Object>> getAdvertiseInfo() {
        List<AdvertiseInfoVO> listVO = advertiseInfoService.SelectAdvertiseInfo();
        return controllerFunc.selectAll(listVO, "payload");
    }

    //채굴기 정보 전체조회
    @GetMapping("/machine/info/get")
    public ResponseEntity<Map<String,Object>> getMiningMachineInfo(){
        List<MiningMachineInfoVO> listVO = miningMachineInfoService.SelectMiningMachineInfo();
        return controllerFunc.selectAll(listVO,"payload");
    }

    //판매상품 전체조회
    @GetMapping("/product/info/get")
    public ResponseEntity<Map<String, Object>> getMiningProductInfo(){
        List<MiningProductVO> listVO = miningProductService.SelectMiningProductInfo();
        return controllerFunc.selectAll(listVO,"payload");
    }

    //판매상품 상세조회
    @GetMapping("/product/info/get/{id}")
    public ResponseEntity<Map<String,Object>> getProductInfo(@PathVariable String id){
        MiningProductVO vo = miningProductService.SelectByIdProductInfo(id);
        return controllerFunc.selectById(vo,"payload");
    }

    //판매 상품 페이징 기능
    @GetMapping("/product/info/get/paging/{id}")
    public ResponseEntity<Map<String, Object>> doPaging(@PathVariable String id){
        int result = miningProductService.CountAllMiningProduct();
        PagingCulDTO dto = new PagingCulDTO(Integer.parseInt(id),2);
        int pageSize = dto.getPazeSize();
        int offset = dto.getOffset();

        List<MiningProductVO> vo = miningProductService.SelectWithPaging(pageSize,offset);
        return controllerFunc.selectAll(vo,"payload");
    }



}









