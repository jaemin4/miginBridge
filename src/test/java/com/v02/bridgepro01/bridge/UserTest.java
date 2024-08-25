package com.v02.bridgepro01.bridge;

import com.v02.bridgepro01.bridge.authSecurity.service.LoginJoinService;
import com.v02.bridgepro01.bridge.authSecurity.domain.UserJoinDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

@SpringBootTest(classes = BridgePro01Application.class)
public class UserTest {
    @Autowired
    LoginJoinService LoginJoinService;


    @Test
    void contextLoad(){}

    @Test
    void loginTest(){
        int cnt = LoginJoinService.countUser();
        UserJoinDTO dto = new UserJoinDTO() {{
            setEmail("test03@naver.com");
            setName("test03");
            setPassword("test03");
            setBirthdate(Date.valueOf("1990-01-01"));
            setKrwBankName("Korean Bank");
            setKrwAccountNumber("1234567890");
            setBitcoinAddress("1A1zP1eP5QGefi2DMPTfTL5SLmv7DivfNa");
            setJoinDate(Timestamp.valueOf("2024-05-25 12:34:56"));
            setUserStatus("ACTIVE");
            setKrwAmount(new BigDecimal("1000000.00"));
            setBitcoinAmount(new BigDecimal("0.12345678"));
        }};

       int result =  LoginJoinService.joinProcess(dto);
        System.out.println(result + " : 결과값");

    }
}
