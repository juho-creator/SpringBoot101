package org.example.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.example.config.jwt.TokenProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * 매 요청마다 실행되며, Authorization 헤더의 JWT 토큰을 검증하고
 * 유효할 경우 인증(Authentication) 객체를 SecurityContext에 설정하는 필터
 */
@RequiredArgsConstructor
public class TokenAuthenticationFilter extends OncePerRequestFilter {

    // JWT 토큰 관련 로직을 담당하는 TokenProvider 의존성 주입
    private final TokenProvider tokenProvider;

    // HTTP Authorization 헤더 이름
    private final static String HEADER_AUTHORIZATION = "Authorization";

    // 토큰 앞에 붙는 접두사 (예: "Bearer eyJ...")
    private final static String TOKEN_PREFIX = "Bearer ";

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {

        // 1. Authorization 헤더에서 토큰 문자열 추출
        String authorizationHeader = request.getHeader(HEADER_AUTHORIZATION);

        // 2. "Bearer " 접두사를 제거한 실제 JWT 값 추출
        String token = getAccessToken(authorizationHeader);

        // 3. 토큰이 유효한 경우 -> 인증(Authentication) 객체 생성 후 SecurityContext에 등록
        if (tokenProvider.verifyToken(token)) {
            Authentication authentication = tokenProvider.getAuthentication(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        // 4. 다음 필터로 요청 전달 (필터 체인 계속 진행) => 응답처리함
        filterChain.doFilter(request, response);
    }

    /**
     * Authorization 헤더에서 "Bearer " 접두사를 제거하고 실제 JWT 토큰만 반환
     * @param authorizationHeader 전체 Authorization 헤더 값
     * @return JWT 토큰 값 또는 null
     */
    private String getAccessToken(String authorizationHeader) {
        if (authorizationHeader != null && authorizationHeader.startsWith(TOKEN_PREFIX)) {
            return authorizationHeader.substring(TOKEN_PREFIX.length());
        }
        return null;
    }
}
