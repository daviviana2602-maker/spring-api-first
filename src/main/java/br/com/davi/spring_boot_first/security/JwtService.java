package br.com.davi.spring_boot_first.security;

import br.com.davi.spring_boot_first.enums.RoleEnum;
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


    public String generateToken(Long userId, RoleEnum role) {

        Date now = new Date();
        Date expiration = new Date(now.getTime() + expirationMinutes * 60 * 1000);

        return Jwts.builder()
                .subject(String.valueOf(userId))      // "sub"
                .claim("role", role)
                .issuedAt(now)
                .expiration(expiration)        // exp
                .signWith(getKey())            // sign with the secret key
                .compact();
    }
}
