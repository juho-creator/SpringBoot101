package org.example.controller;


import io.jsonwebtoken.Jwt;
import lombok.RequiredArgsConstructor;
import org.example.config.jwt.JwtProperties;
import org.example.config.jwt.TokenProvider;
import org.example.domain.User;
import org.example.service.UserDetailService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;

@RequiredArgsConstructor
@RestController
public class TestController {

    private final UserDetailService userDetailService;
    private final TokenProvider tokenProvider;
    private final JwtProperties jwtProperties;


    @GetMapping("/articles/jwt/{email}")
    public String getJwt(@PathVariable String email){

        User user = userDetailService.loadUserByUsername(email);
        System.out.println("issuer: " + jwtProperties.getIssuer());
        System.out.println("secret key: " + jwtProperties.getSecretKey());

        String token = tokenProvider.generateToken(user,Duration.ofMinutes(1));
        Boolean validation = tokenProvider.verifyToken(token);
        Authentication auth = tokenProvider.getAuthentication(token);
        Long userId = tokenProvider.getUserId(token);


        return "issuer: " + jwtProperties.getIssuer() + "<br><br>"
                + "secret key: " + jwtProperties.getSecretKey() + "<br>"
                + "user Id : " + userId + "<br>"
                + "token : " + token + "<br>"
                + "validation : " + validation + "<br>"
                + "auth : " + auth + "<br>";

    }

}
