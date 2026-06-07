package br.com.davi.spring_boot_first.service;

import br.com.davi.spring_boot_first.dto.response.ConcluirPedidoResponse;
import br.com.davi.spring_boot_first.entity.CarrinhoEntity;
import br.com.davi.spring_boot_first.entity.ConcluidosEntity;
import br.com.davi.spring_boot_first.entity.PedidoEntity;
import br.com.davi.spring_boot_first.enums.PedidoStatusEnum;
import br.com.davi.spring_boot_first.repository.CarrinhoRepository;
import br.com.davi.spring_boot_first.repository.ConcluidosRepository;
import br.com.davi.spring_boot_first.repository.PedidoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ConcluirPedidoService {

    private final ConcluidosRepository concluidosRepository;
    private final CarrinhoRepository carrinhoRepository;
    private final PedidoRepository pedidoRepository;


    public ConcluirPedidoService(ConcluidosRepository concluidosRepository,
                                 CarrinhoRepository carrinhoRepository,
                                 PedidoRepository pedidoRepository) {
        this.concluidosRepository = concluidosRepository;
        this.carrinhoRepository = carrinhoRepository;
        this.pedidoRepository = pedidoRepository;
    }


    public PedidoEntity buscarPedidoId(Long pedidoId) {
        return pedidoRepository.findById(pedidoId)
            .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
    }

    
    @Transactional
    public List<ConcluirPedidoResponse> concluirPedido(Long pedidoId) {

        PedidoEntity pedido = buscarPedidoId(pedidoId);

        pedido.setStatus(PedidoStatusEnum.CONCLUIDO);
        pedidoRepository.save(pedido);


        List<CarrinhoEntity> carrinho = carrinhoRepository.findByPedidoId(pedidoId);

        List<ConcluirPedidoResponse> response = new ArrayList<>();

        for (CarrinhoEntity car : carrinho) {

            ConcluidosEntity concluido = new ConcluidosEntity();

            concluido.setPedidoId(pedidoId);
            concluido.setProdutoId(car.getProdutoId());
            concluido.setQuantidade(car.getQuantidade());
            concluido.setPrecoUnit(car.getPrecoUnit());
            concluido.setPrecoTotal(car.getPrecoTotal());

            ConcluidosEntity salvo = concluidosRepository.save(concluido);

            response.add(
                    new ConcluirPedidoResponse(
                            salvo.getId(),
                            salvo.getPedidoId(),
                            salvo.getProdutoId(),
                            salvo.getQuantidade(),
                            salvo.getPrecoUnit(),
                            salvo.getPrecoTotal()
                    )
            );

        }

        carrinhoRepository.deleteByPedidoId(pedidoId);

        return response;

    }

}
