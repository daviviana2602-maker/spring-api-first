package br.com.davi.spring_boot_first.service;

import br.com.davi.spring_boot_first.dto.response.CriarContaResponse;
import br.com.davi.spring_boot_first.entity.UsuarioEntity;
import br.com.davi.spring_boot_first.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class CriarContaService {


    private final UsuarioRepository usuarioRepository;


    public CriarContaService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }


    public CriarContaResponse criarConta(String nome, String senha){


        UsuarioEntity usuario = new UsuarioEntity();

        usuario.setNome(nome);
        usuario.setSenha(senha);

        usuarioRepository.save(usuario);


        return new CriarContaResponse(
            usuario.getId(),
            usuario.getNome()
        );

    }

}
