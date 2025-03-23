package com.vho.user_service.infraestructure.security;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.SecretKey;


@Component
public class JwtService {

    private static final String SECRET = "b33570a4e6c4c69eb9f09b72338f0b60800b9135233979e0470d2cf0a290c7aa3be69c50cb16618876956c397e5e60d8ffdcc158d989d002d1b70d1f69465da2d8320d9d9a64306082eebb762c1b808f5ae916c4309a2e0eb1523550e51a0cf601953d99bc275bc16216196b35027fe92d8352c7d81337504f0697cba1f9c24ee53d12d960a21597d13f8c546421d07cd9ca0cd9643e70d584d65719fae61ab324d8d6c1015759d59adb409123b8f6d8be7c887bc5b83c4d4835f4ef71465f00fdc5ab45cbe498d13c6426a56f6386cc158c75ef07c0001af71887d53a26f733d70e12a3cf6621d186e1876b76c4ec2d5ecf83319cb702b2d34bdabd96c8d535";

    private SecretKey getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String generateToken(String userName) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, userName);
    }

    private String createToken(Map<String, Object> claims, String userName) {
        return Jwts.builder()
                .claims(claims)
                .subject(userName)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 30))
                .signWith(getSignKey(), Jwts.SIG.HS256) 
                .compact();
    }

    public void validateToken(final String token) {
        try {
            Jwts.parser()
                .verifyWith(getSignKey()) 
                .build()
                .parseSignedClaims(token);
        } catch (JwtException e) {
            throw new RuntimeException("Invalid Token", e);
        }
    }
}