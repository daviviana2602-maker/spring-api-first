package br.com.davi.spring_boot_first.service;

import br.com.davi.spring_boot_first.enums.RoleEnum;
import br.com.davi.spring_boot_first.security.JwtDataFormat;
import br.com.davi.spring_boot_first.security.JwtService;
import org.springframework.stereotype.Service;


@Service
public class TokenService {

    private final JwtService jwtService;


    public TokenService(JwtService jwtService) {
        this.jwtService = jwtService;
    }


    public String refreshAccessToken(String refreshToken) {

        JwtDataFormat data = jwtService.extractClaims(refreshToken);

        Long userId = Long.valueOf(data.getUserId());
        RoleEnum role = RoleEnum.valueOf(data.getRole());

        return jwtService.generateAccessToken(userId, role);

    }


}
