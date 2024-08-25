package com.v02.bridgepro01.bridge.authSecurity;

import com.v02.bridgepro01.bridge.authSecurity.service.CustomUserDetailService;
import com.v02.bridgepro01.bridge.authSecurity.domain.UserJoinDTO;
import com.v02.bridgepro01.bridge.authSecurity.service.LoginJoinService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class AuthController {

    private final LoginJoinService loginJoinService;
    private final CustomUserDetailService customUserDetailService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    @PostMapping("/join")
    public ResponseEntity<String> join(@RequestBody UserJoinDTO dto) {
        try {
            int result = loginJoinService.joinProcess(dto);
            if (result == 1) {
                return ResponseEntity.ok().body("success");
            } else {
                return ResponseEntity.badRequest().body("error: registration failed");
            }
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("error: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error: " + e.getMessage());
        }
    }






}
