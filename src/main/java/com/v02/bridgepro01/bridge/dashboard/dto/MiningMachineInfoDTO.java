package com.v02.bridgepro01.bridge.dashboard.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MiningMachineInfoDTO {

    //채굴기 이름
    private String miningMachineName;

    //채굴기 가격
    private String miningMachinePrice;

    //채굴기 일일수익
    private String miningMachineDayProfit;

    //채굴기 일일전기료
    private String miningMachineDayElelectricFee;

    //채굴기 일일 예상수익
    private String miningMachineExpectDayProfit;


}
