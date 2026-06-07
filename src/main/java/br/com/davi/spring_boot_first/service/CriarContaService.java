package br.com.davi.spring_boot_first.service;

import br.com.davi.spring_boot_first.dto.response.CriarContaResponse;
import br.com.davi.spring_boot_first.entity.UsuarioEntity;
import br.com.davi.spring_boot_first.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class CriarContaService {


    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;


    public CriarContaService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Transactional
    public CriarContaResponse criarConta(String nome, String email, String senha){


        UsuarioEntity usuario = new UsuarioEntity();

        usuario.setNome(nome);
        usuario.setEmail(email);

        String senhaHash = passwordEncoder.encode(senha);
        usuario.setSenha(senhaHash);


        usuarioRepository.save(usuario);


        return new CriarContaResponse(
            usuario.getId(),
            usuario.getNome(),
            usuario.getEmail()
        );

    }

}
