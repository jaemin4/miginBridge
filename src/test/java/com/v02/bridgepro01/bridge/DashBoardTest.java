package com.v02.bridgepro01.bridge;


import com.v02.bridgepro01.bridge.common.status.PagingCulDTO;
import com.v02.bridgepro01.bridge.dashboard.vo.AdvertiseInfoVO;
import com.v02.bridgepro01.bridge.dashboard.vo.MiningMachineInfoVO;
import com.v02.bridgepro01.bridge.dashboard.vo.MiningProductVO;
import com.v02.bridgepro01.bridge.dashboard.AdvertiseInfoService;
import com.v02.bridgepro01.bridge.dashboard.MiningMachineInfoService;
import com.v02.bridgepro01.bridge.dashboard.MiningProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = BridgePro01Application.class)
public class DashBoardTest {
    @Autowired
    AdvertiseInfoService advertiseInfoService;

    @Autowired
    MiningMachineInfoService miningMachineInfoService;

    @Autowired
    MiningProductService miningProductService;
    @Test
    void contextLoads(){

    }
    //AdvertiseInfo SelectAll
    @Test
    void adverTiseInfoTest(){
        List<AdvertiseInfoVO> vo = advertiseInfoService.SelectAdvertiseInfo();
    }

    //MiningMachineInfo SelectAll
    @Test
    void MiningMachineInfoTest(){
        List<MiningMachineInfoVO> vo = miningMachineInfoService.SelectMiningMachineInfo();
    }

    //상품 전체조회
    @Test
    void MiningProductSelectAllTest(){
        List<MiningProductVO> vo = miningProductService.SelectMiningProductInfo();
    }

    //상품 상세조회
    @Test
    void MiningProductSelectByIdTest(){
        String id = "MMP01";
        MiningProductVO vo = miningProductService.SelectByIdProductInfo(id);
    }

    //상품 대시보드 개수 구하기
    @Test
    void MiningProductSelectAll(){
        int result = miningProductService.CountAllMiningProduct();
    }


    //상품 대시보드 페이징
    @Test
    void MiningProductPaging(){
        int result = miningProductService.CountAllMiningProduct();
        PagingCulDTO dto = new PagingCulDTO(3,5);
        int pageSize = dto.getPazeSize();
        int offset = dto.getOffset();

        List<MiningProductVO> listVo = miningProductService.SelectWithPaging(pageSize,offset);

    }



}
