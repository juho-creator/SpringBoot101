package org.example.config;

import lombok.RequiredArgsConstructor;
import org.example.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
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

// 스프링 시큐리티 설정
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebApplicationConfig {
    private final UserDetailService userDetailService;

    // 1. Disabling Spring Security
    @Bean
    public WebSecurityCustomizer config(){
        return (web) -> web.ignoring()
                .requestMatchers(toH2Console())
                .requestMatchers(new AntPathRequestMatcher("/static/**"));
    }

    // 2. Path & Authentication/Authorization settings
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        return http.authorizeRequests(
                auth->auth.requestMatchers(
                        new AntPathRequestMatcher("/login"),
                        new AntPathRequestMatcher("/user"),
                        new AntPathRequestMatcher("/signup")
                ).permitAll().anyRequest().authenticated())
                .formLogin(formLogin -> formLogin
                        .loginPage("/login")
                        .defaultSuccessUrl("/articles"))
                .logout(logout -> logout
                        .logoutSuccessUrl("/login")
                        .invalidateHttpSession(true))
                .csrf(AbstractHttpConfigurer::disable)
                .build();
    }

    // 3. Authentication manager Setting
    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http,
                                                       BCryptPasswordEncoder bCryptPasswordEncoder, UserDetailService userDetailService){

        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setPasswordEncoder(bCryptPasswordEncoder);
        authProvider.setUserDetailsService(userDetailService);
        return new ProviderManager(authProvider);
    }

    // 4. Password encoder setting
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
