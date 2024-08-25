package com.v02.bridgepro01.bridge.authSecurity.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserJoinDTO {

    private String email;
    private String userIdentifyId;
    private String password;
    private String name;
    private Date birthdate;
    private String krwBankName;
    private String krwAccountNumber;
    private String bitcoinAddress;
    private Timestamp joinDate;
    private String userStatus;
    private BigDecimal krwAmount;
    private BigDecimal bitcoinAmount;
    private String role;


    public void setUserIdentifyId(String userIdentifyId) {
        this.userIdentifyId = "user"+ userIdentifyId;
    }




}
