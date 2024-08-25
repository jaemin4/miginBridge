package com.v02.bridgepro01.bridge.authSecurity.service;

import com.v02.bridgepro01.bridge.authSecurity.domain.UserJoinDTO;

public interface LoginJoinService {

    int joinProcess(UserJoinDTO dto);

    int countUser();

/*    userVO findByUsername(String username);*/
}
