package com.v02.bridgepro01.bridge.authSecurity.service;

import com.v02.bridgepro01.bridge.authSecurity.repository.LoginJoinRepository;
import com.v02.bridgepro01.bridge.authSecurity.domain.UserAccessDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final LoginJoinRepository loginJoinRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAccessDTO userData = loginJoinRepository.findByUsername(username);

        if(userData != null ){
            //UserDetail에 담아서 return하면 AuthenticationManager가 검증함
            return new CustomUserDetails(userData);
        }
        return null;
    }
}
