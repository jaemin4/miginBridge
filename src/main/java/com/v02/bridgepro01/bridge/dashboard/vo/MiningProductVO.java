package com.v02.bridgepro01.bridge.dashboard.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MiningProductVO {


    //Insert MiningMachineProduct약자 따서 MMP01,MMP02,MMP03~
    private String ProductID;

    //채굴기명
    private String MachineName;

    //채굴기 가격
    private float MachinePrice;

    //원화 판매가
    private float SaleproKRW;

    //월 관리비
    private float MonthManageFee;

    //계약기간(개월) 12 = 12개월 ,24 = 24개월
    private int InitialTerm;

    //판매 상태
    //0 : 미판매 , 1 : 판매중
    //사용자가 결제하거나,채굴업장이 판매 내릴시 0으로 바뀜
    //SaleStatus가 1인 상품만 조회
    //SaleStatus가 0인 상품은 DB스케줄러로 자정마다 지워줌
    private int SaleStatus;

    //판매자
    //[채굴업장 식별 ID] Insert해야함
    private String SalerID;






}
