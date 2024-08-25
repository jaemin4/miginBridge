package com.v02.bridgepro01.bridge.authSecurity.service;

import com.v02.bridgepro01.bridge.authSecurity.repository.LoginJoinRepository;
import com.v02.bridgepro01.bridge.authSecurity.domain.UserJoinDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginJoinServiceImpl implements LoginJoinService {

    private final LoginJoinRepository loginJoinRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public int joinProcess(UserJoinDTO dto) {
        String userName = dto.getEmail();
        String password = dto.getPassword();


        // 비밀번호 암호화
        dto.setPassword(bCryptPasswordEncoder.encode(password));
        dto.setRole("ADMIN");

        // 고유 식별자 설정
        String countUser = Integer.toString(loginJoinRepository.countUser());
        dto.setUserIdentifyId(countUser);

        // 사용자 등록 처리
        try{
            loginJoinRepository.joinProcess(dto);
            return 1;
        } catch (Exception e){
            e.printStackTrace();
            return 0;
        }

    }

    @Override
    public int countUser() {
        return loginJoinRepository.countUser();
    }


}
