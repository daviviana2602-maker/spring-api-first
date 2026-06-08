package br.com.davi.spring_boot_first.security;

import br.com.davi.spring_boot_first.enums.RoleEnum;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;


@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private long expirationMinutes;


    private SecretKey getKey() {
        return Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));  // Transform the secret in a new SecretKey (JWT use it to sign and validate token)
    }


    public JwtDataFormat extractClaims(String token) {

        Claims claims = Jwts.parser()
                .verifyWith(getKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();       // extract the body of token

        return new JwtDataFormat(
            claims.getSubject(),
            claims.get("role", String.class)    // transform unknown object to String
        );

    }


    public String generateToken(Long userId, RoleEnum role) {

        Date now = new Date();
        Date expiration = new Date(now.getTime() + expirationMinutes * 60 * 1000);   // transform to milliseconds

        return Jwts.builder()
                .subject(String.valueOf(userId))
                .claim("role", role)
                .issuedAt(now)
                .expiration(expiration)
                .signWith(getKey())
                .compact();
    }
}
