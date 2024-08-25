package com.v02.bridgepro01.bridge.authSecurity.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserAccessDTO {

    private String email;
    private String password;
    private String role;
}
