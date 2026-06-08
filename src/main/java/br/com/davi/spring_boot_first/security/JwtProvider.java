package br.com.davi.spring_boot_first.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;
import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;


@Service
public class JwtProvider {

    private static final String SECRET =
        "minha-chave-super-secreta-com-pelo-menos-32-caracteres";


    private SecretKey getKey() {
            return Keys.hmacShaKeyFor(
                    SECRET.getBytes(StandardCharsets.UTF_8)
            );
        }


    public String generateToken(Long userId) {

        return Jwts.builder()
            .subject(userId.toString())
            .issuedAt(new Date())
            .expiration(
                new Date(
                    System.currentTimeMillis()
                    + 1000 * 60 * 60 * 24
                )
                )
                .signWith(getKey())
                .compact();

        }

    }
