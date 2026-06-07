package br.com.davi.spring_boot_first.service;

import br.com.davi.spring_boot_first.entity.CarrinhoEntity;
import br.com.davi.spring_boot_first.entity.PedidoEntity;
import br.com.davi.spring_boot_first.enums.PedidoStatusEnum;
import br.com.davi.spring_boot_first.repository.CarrinhoRepository;
import br.com.davi.spring_boot_first.repository.PedidoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CancelarPedidoService {

    private final PedidoRepository pedidoRepository;
    private final CarrinhoRepository carrinhoRepository;


    public CancelarPedidoService(PedidoRepository pedidoRepository, CarrinhoRepository carrinhoRepository) {
        this.pedidoRepository = pedidoRepository;
        this.carrinhoRepository = carrinhoRepository;
    }


    private PedidoEntity buscarPedidoId(Long pedidoId) {
        return pedidoRepository.findById(pedidoId)
                .orElseThrow(() -> new RuntimeException("pedido não encontrado"));
    }


    @Transactional
    public Long cancelarPedido(Long pedidoId) {

        PedidoEntity pedido = buscarPedidoId(pedidoId);

        pedido.setStatus(PedidoStatusEnum.CANCELADO);
        pedidoRepository.save(pedido);


        List<CarrinhoEntity> carrinho = carrinhoRepository.findByPedidoId(pedidoId);

        for (CarrinhoEntity item : carrinho) {
            carrinhoRepository.delete(item);
        }


       return pedidoId;
    }

}
