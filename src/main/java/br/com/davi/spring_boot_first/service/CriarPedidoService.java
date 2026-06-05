package br.com.davi.spring_boot_first.service;

import br.com.davi.spring_boot_first.dto.response.PedidoResponse;
import br.com.davi.spring_boot_first.entity.PedidoEntity;
import br.com.davi.spring_boot_first.entity.UsuarioEntity;
import br.com.davi.spring_boot_first.enums.PedidoStatusEnum;
import br.com.davi.spring_boot_first.repository.PedidoRepository;
import br.com.davi.spring_boot_first.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
public class CriarPedidoService {

    private final PedidoRepository pedidoRepository;
    private final UsuarioRepository usuarioRepository;


    public CriarPedidoService(PedidoRepository pedidoRepository, UsuarioRepository usuarioRepository) {
        this.pedidoRepository = pedidoRepository;
        this.usuarioRepository = usuarioRepository;
    }


    private UsuarioEntity buscarPorId(Long usuarioId) {
        return usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("usuario não encontrado"));
    }


    public PedidoResponse criarPedido(Long usuarioId){

        List<PedidoEntity> produtos = pedidoRepository.findByUsuarioId(usuarioId);


        for (PedidoEntity p : produtos){

            if (p.getStatus().equals("PENDENTE")) {

                throw new ResponseStatusException(
                        HttpStatus.CONFLICT
                );

            }
        }


        UsuarioEntity usuario = buscarPorId(usuarioId);

        PedidoEntity pedido = new PedidoEntity();


        pedido.setUsuarioId(usuario.getId());
        pedido.setStatus(PedidoStatusEnum.PENDENTE);

        pedidoRepository.save(pedido);

        return new PedidoResponse(
            usuario.getId(),
            pedido.getUsuarioId(),
            usuario.getNome(),
            pedido.getStatus()
        );

    }

}
