package com.v02.bridgepro01.bridge.authSecurity.filter;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

public class LoginFilter extends UsernamePasswordAuthenticationFilter {

    //authenticationManager 주입
    private final AuthenticationManager authenticationManager;

    //JWTUtil 주입
    private final JWTUtil jwtUtil;


    public LoginFilter(AuthenticationManager authenticationManager,JWTUtil jwtUtil){
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;

        // 로그인 요청 URL 설정
        setFilterProcessesUrl("/user/login");
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        //클라이언트 요청에서 username,paassword 추출
        String username = obtainUsername(request);
        String password = obtainPassword(request);

        //스프링 시큐리티에서 username과 password를 검증하기 위해서는 token에 담아야 한다.
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username,password,null);

        //token에 담은 검증을 위한 AuthenticationManager로 전달


        return authenticationManager.authenticate(authToken);
    }

    //로그인 성공시 실행하는 메서드(여기서 JWT발급)
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) throws IOException, ServletException {

        //여기서 getUsername이지만, email을 가져오게 된다.
        String username = authentication.getName();
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        Iterator<? extends GrantedAuthority> iterator = authorities.iterator();
        GrantedAuthority auth = iterator.next();
        String role = auth.getAuthority();

        //토큰 생성
        String access = jwtUtil.createJwt("access",username, role, 60*60*10L);
        String refresh = jwtUtil.createJwt("refresh",username,role,86400000L);

        //응답 설정
        response.setHeader("access",access);
        response.addCookie(createCookie("refresh",refresh));
        response.setStatus(HttpStatus.OK.value());
    }

    //로그인 실패시 실행하는 메서드
    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        response.setStatus(401);
    }

    private Cookie createCookie(String key,String value){
        Cookie cookie = new Cookie(key,value);
        cookie.setMaxAge(24*60*60);
        cookie.setHttpOnly(true);
        return cookie;
    }

//    private void addRefreshEntity(String username,String refresh,Long expiredMs){
//        Date date = new Date(System.currentTimeMillis() + expiredMs);
//        RefreshEntity refreshEntity = new RefreshEntity();
//        refreshEntity.setEmail(username);
//        refreshEntity.setRefresh(refresh);
//        refreshEntity.setExpiration(date.toString());
//
//        refreshRepositoryImpl.saveToken(refreshEntity);
//    }
}
