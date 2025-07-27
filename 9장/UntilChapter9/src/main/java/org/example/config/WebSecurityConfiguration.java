package org.example.config;


import lombok.RequiredArgsConstructor;
import org.example.service.UserDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;

@RequiredArgsConstructor
@EnableWebSecurity
@Configuration
public class WebSecurityConfiguration {

    private final UserDetailService userDetailService;


    // 1. 스프링 시큐리티 설정 비활성화
    @Bean
    public WebSecurityCustomizer config(){
        return (web) -> web.ignoring()
                .requestMatchers(new AntPathRequestMatcher("/static/**"))
                .requestMatchers(toH2Console());
    }


    // 2. http 경로 및 인증 인가 설정
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        return http.authorizeRequests(
                auth -> auth.requestMatchers(
                        new AntPathRequestMatcher("/user"),
                        new AntPathRequestMatcher("/login"),
                        new AntPathRequestMatcher("/signup")
                ).permitAll().anyRequest().authenticated())
                .formLogin(login -> login
                        .loginPage("/login")
                        .defaultSuccessUrl("/articles"))
                .logout(logout -> logout
                        .logoutSuccessUrl("/login")
                        .invalidateHttpSession(true))
                .csrf(AbstractHttpConfigurer::disable)
                .build();
        }

    // 3. 비밀번호 검증 설정
    @Bean
    public AuthenticationManager authenticationManager(BCryptPasswordEncoder bCryptPasswordEncoder, UserDetailService userDetailService){
        DaoAuthenticationProvider daoProvider = new DaoAuthenticationProvider();
        daoProvider.setUserDetailsService(userDetailService);
        daoProvider.setPasswordEncoder(bCryptPasswordEncoder);
        return new ProviderManager(daoProvider);
    }

    // 4. 암호화 설정
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
