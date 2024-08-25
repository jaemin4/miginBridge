package com.v02.bridgepro01.bridge.dashboard.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MiningProductDTO {

    //샹폼ID
    private String ProductID;

    //채굴기명
    private String ProductName;

    //채굴기 가격
    private float Price;

    //월 관리비
    private float MonthManageFee;

    //계약기간
    private int InitialTerm;

    //판매 상태
    private int SaleStatus;

    //판매자
    private String Saler;

    //원화 판매가
    private float SaleKRW;





}
