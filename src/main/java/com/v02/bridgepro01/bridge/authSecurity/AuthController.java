package com.v02.bridgepro01.bridge.authSecurity;

import com.v02.bridgepro01.bridge.authSecurity.filter.JWTUtil;
import com.v02.bridgepro01.bridge.authSecurity.service.CustomUserDetailService;
import com.v02.bridgepro01.bridge.authSecurity.domain.UserJoinDTO;
import com.v02.bridgepro01.bridge.authSecurity.service.LoginJoinService;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class AuthController {

    private final LoginJoinService loginJoinService;
    private final CustomUserDetailService customUserDetailService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final JWTUtil jwtUtil;
//    private final RefreshRepositoryImpl refreshRepositoryImpl;


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

    @PostMapping("/reissue")
    public ResponseEntity<?> reissue(HttpServletRequest request, HttpServletResponse response) {

        //get refresh token
        String refresh = null;
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("refresh")) {
                refresh = cookie.getValue();
            }
        }

        if (refresh == null) {
            return new ResponseEntity<>("refresh token null", HttpStatus.BAD_REQUEST);
        }

        //expired check
        try {
            jwtUtil.isExpired(refresh);
        } catch (ExpiredJwtException e) {
            return new ResponseEntity<>("refresh token expired", HttpStatus.BAD_REQUEST);
        }

        // 토큰이 refresh인지 확인 (발급시 페이로드에 명시)
        String category = jwtUtil.getCategory(refresh);

        if (!category.equals("refresh")) {
            return new ResponseEntity<>("invalid refresh token", HttpStatus.BAD_REQUEST);
        }

        //DB에 저장되어 있는지 확인
//        Boolean isExist = refreshRepositoryImpl.tokenExists(refresh);
//        if (!isExist) {
//            return new ResponseEntity<>("invalid refresh token", HttpStatus.BAD_REQUEST);
//        }

        String username = jwtUtil.getUsername(refresh);
        String role = jwtUtil.getRole(refresh);

        //make new JWT
        String newAccess = jwtUtil.createJwt("access", username, role, 600000L);
        String newRefresh = jwtUtil.createJwt("refresh", username, role, 86400000L);

        //Refresh 토큰 저장 DB에 기존의 Refresh 토큰 삭제 후 새 Refresh 토큰 저장
//        refreshRepositoryImpl.deleteToken(refresh);
//        addRefreshEntity(username, newRefresh, 86400000L);

        //response
        response.setHeader("access", newAccess);
        response.addCookie(createCookie("refresh", newRefresh));

        return new ResponseEntity<>(HttpStatus.OK);
    }


    private Cookie createCookie(String key,String value){
        Cookie cookie = new Cookie(key,value);
        cookie.setMaxAge(24*60*60);
        cookie.setHttpOnly(true);
        return cookie;
    }

//    private void addRefreshEntity(String username, String refresh, Long expiredMs) {
//
//        Date date = new Date(System.currentTimeMillis() + expiredMs);
//
//        RefreshEntity refreshEntity = new RefreshEntity();
//        refreshEntity.setEmail(username);
//        refreshEntity.setRefresh(refresh);
//        refreshEntity.setExpiration(date.toString());
//
//        refreshRepositoryImpl.saveToken(refreshEntity);
//    }



}
