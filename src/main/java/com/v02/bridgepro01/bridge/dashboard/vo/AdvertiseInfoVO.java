package com.v02.bridgepro01.bridge.dashboard.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.sql.Date;

@Getter
@AllArgsConstructor
public class AdvertiseInfoVO {

    //광고 id
    private String advertiseID;

    //광고 Text1
    private String advertiseText1;

    //광고 Text2
    private String advertiseText2;

    //광고 이미지
    private String advertiseIMG;

    //광고 종료일
    private Date advertiseEndDate;

    //광고 등록일
    private Date advertiseUploadDate;
}
