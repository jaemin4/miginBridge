package com.v02.bridgepro01.bridge.config;

import com.v02.bridgepro01.bridge.authSecurity.filter.CustomLogoutFilter;
import com.v02.bridgepro01.bridge.authSecurity.filter.JWTFilter;
import com.v02.bridgepro01.bridge.authSecurity.filter.JWTUtil;
import com.v02.bridgepro01.bridge.authSecurity.filter.LoginFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutFilter;

@Configuration
@EnableWebSecurity
public class securityConfig {

    //AuthenticationManager가 인자로 받을 AuthenticationConfiguration 객체 생성자 주입
    private final AuthenticationConfiguration authenticationConfiguration;

    //JWTUtil 주입
    private final JWTUtil jwtUtil;



    //생성자
    public securityConfig(AuthenticationConfiguration authenticationConfiguration, JWTUtil jwtUtil) {
        this.authenticationConfiguration = authenticationConfiguration;
        this.jwtUtil = jwtUtil;
    }


    //AuthenticationManager Bean 등록
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws  Exception{
        return configuration.getAuthenticationManager();
    }

    //passwordEncoder 주입
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    //
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // CSRF disable
        http
                .csrf(csrf -> csrf.disable());

        // Form 로그인 방식 disable
        http
                .formLogin(form -> form.disable());

        // HTTP Basic 인증 방식 disable
        http
                .httpBasic(basic -> basic.disable());

        // 경로별 인가 작업
        http
                .authorizeHttpRequests(auth -> auth
                        .antMatchers("/logout").permitAll()
                        .antMatchers("/user/login").permitAll()
                        .antMatchers("/files/**").permitAll()
                        .antMatchers("/user/**").permitAll()
                        .antMatchers("/admin/test").hasRole("ADMIN")
                        .antMatchers("/dashboard/**").permitAll()
                        .antMatchers("/announcement/**").permitAll()
                        .anyRequest().authenticated());

        // 세션 설정
        http
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        //JWTFilter 등록
        http
                .addFilterBefore(new JWTFilter(jwtUtil), LoginFilter.class);

        // **loginSecurity기능 ++ LoginFilter()는 인자를 받음(AuthenticationManager() 메서드에 authenticationConfiguration 객체를 넣어야함) 따라서 등록 필요
        http
                .addFilterAt(new LoginFilter(authenticationManager(authenticationConfiguration),jwtUtil), UsernamePasswordAuthenticationFilter.class);

        // 로그아웃
        http
                .addFilterBefore(new CustomLogoutFilter(jwtUtil), LogoutFilter.class);
        return http.build();
    }
}
