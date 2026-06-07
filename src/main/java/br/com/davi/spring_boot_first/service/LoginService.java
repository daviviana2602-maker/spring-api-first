package br.com.davi.spring_boot_first.service;

import br.com.davi.spring_boot_first.dto.response.LoginResponse;
import br.com.davi.spring_boot_first.entity.UserEntity;
import br.com.davi.spring_boot_first.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class LoginService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public LoginService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    private UserEntity findEmail(String email) {
        return userRepository.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("User not found!"));
    }


    public LoginResponse systemLogin(String email, String senha){

        UserEntity user = findEmail(email);


        if (!passwordEncoder.matches(senha, user.getPassword())) {
            throw new RuntimeException("wrong email or password");
        }


        return new LoginResponse(
            user.getId(),
            user.getName(),
            user.getEmail()
        );

    }

}
