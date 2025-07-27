package org.example.config.jwt;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

// jwt 발급자와 비밀키 접근하기 위한 객체
@Setter
@Getter
@ConfigurationProperties("jwt")
@Component
public class JwtProperties {
    String issuer;
    String secretKey;
}
