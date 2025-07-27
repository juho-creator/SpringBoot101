package org.example.service;


import lombok.RequiredArgsConstructor;
import org.example.config.jwt.TokenProvider;
import org.example.domain.RefreshToken;
import org.example.domain.User;
import org.springframework.stereotype.Service;

import java.time.Duration;

@RequiredArgsConstructor
@Service
public class TokenService {
    private final TokenProvider tokenProvider;
    private final RefreshTokenService refreshTokenService;
    private final UserService userService;

    // 토큰 유효성 검사게 실패하면 예외 발생
    public String createNewAccessToken(String refreshToken){

        // 1. 리프레시 토큰의 유효성 검사를 한다
        if (!tokenProvider.verifyToken(refreshToken)){
            throw new IllegalArgumentException("Unexpected token");
        }

        // 2. 해당 리프레시 토큰의 유저를 찾는다
        Long userId = refreshTokenService.findByRefreshToken(refreshToken).getUserId();
        User user = userService.findById(userId);


        // 3. 해당 유저에게 새로운 access token을 발급한다
        return tokenProvider.generateToken(user, Duration.ofHours(2));
    }
}
