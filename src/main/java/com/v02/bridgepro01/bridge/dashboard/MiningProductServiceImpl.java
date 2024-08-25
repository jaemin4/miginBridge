package com.v02.bridgepro01.bridge.dashboard;

import com.v02.bridgepro01.bridge.dashboard.vo.MiningProductVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MiningProductServiceImpl implements MiningProductService {

    private final MiningProductRepository miningProductRepository;
    @Override
    public List<MiningProductVO> SelectMiningProductInfo() {
        return miningProductRepository.SelectMiningProductInfo();
    }

    @Override
    public MiningProductVO SelectByIdProductInfo(String id) {
        return miningProductRepository.SelectByIdMiningProductInfo(id);
    }

    @Override
    public List<MiningProductVO> SelectWithPaging(int pageSize, int offset) {
        return miningProductRepository.SelectWithPaging(pageSize,offset);
    }

    @Override
    public int CountAllMiningProduct() {
        return miningProductRepository.CountAllMiningProduct();
    }
}
