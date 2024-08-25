package com.v02.bridgepro01.bridge.authSecurity.repository;

import com.v02.bridgepro01.bridge.authSecurity.domain.UserAccessDTO;
import com.v02.bridgepro01.bridge.authSecurity.domain.UserJoinDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginJoinRepository {


    void joinProcess(UserJoinDTO dto);

    int countUser();

    //username을 받아 DB 테이블에서 회원을 조회하는 메소드 작성
    UserAccessDTO findByUsername(String username);


}
