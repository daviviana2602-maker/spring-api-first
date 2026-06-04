package br.com.davi.spring_boot_first.service;

import br.com.davi.spring_boot_first.dto.response.LoginResponse;
import br.com.davi.spring_boot_first.entity.UsuarioEntity;
import br.com.davi.spring_boot_first.repository.UsuarioRepository;
import org.springframework.stereotype.Service;


@Service
public class LoginService {

    private final UsuarioRepository usuarioRepository;


    public LoginService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }


    public LoginResponse realizarLogin(String email, String senha){

        UsuarioEntity usuario = usuarioRepository.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));


        if (!usuario.getSenha().equals(senha)) {
            throw new RuntimeException("Senha incorreta");
        }


        return new LoginResponse(
            usuario.getId(),
            usuario.getNome(),
            usuario.getEmail()
        );

    }

}
