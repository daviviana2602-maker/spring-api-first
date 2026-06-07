package br.com.davi.spring_boot_first.service;

import br.com.davi.spring_boot_first.dto.response.CarrinhoResponse;
import br.com.davi.spring_boot_first.entity.CarrinhoEntity;
import br.com.davi.spring_boot_first.repository.CarrinhoRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ListarItensPedidoService {

    private final CarrinhoRepository carrinhoRepository;


    public ListarItensPedidoService(CarrinhoRepository carrinhoRepository) {
        this.carrinhoRepository = carrinhoRepository;
    }


    public List<CarrinhoResponse> listarItens(Long pedidoId) {

        List<CarrinhoEntity> carrinho = carrinhoRepository.findByPedidoId(pedidoId);


        return carrinho.stream()    // passa por cada item da lista em sequência
                .map(item -> new CarrinhoResponse(  // transforma Entity em Response
                        item.getId(),
                        item.getPedidoId(),
                        item.getProdutoId(),
                        item.getQuantidade(),
                        item.getPrecoUnit(),
                        item.getPrecoTotal()
                ))
                .toList();  // chama o stream e insere itens passados na lista

    }

}
