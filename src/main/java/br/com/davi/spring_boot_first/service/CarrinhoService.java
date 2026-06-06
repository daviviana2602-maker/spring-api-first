package br.com.davi.spring_boot_first.service;

import br.com.davi.spring_boot_first.dto.response.CarrinhoResponse;
import br.com.davi.spring_boot_first.entity.CarrinhoEntity;
import br.com.davi.spring_boot_first.entity.PedidoEntity;
import br.com.davi.spring_boot_first.entity.ProdutoEntity;
import br.com.davi.spring_boot_first.repository.CarrinhoRepository;
import br.com.davi.spring_boot_first.repository.PedidoRepository;
import br.com.davi.spring_boot_first.repository.ProdutoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.Optional;


@Service
public class CarrinhoService {

    private final CarrinhoRepository carrinhoRepository;
    private final ProdutoRepository produtoRepository;
    private final PedidoRepository pedidoRepository;


    public CarrinhoService(CarrinhoRepository carrinhoRepository,
                           ProdutoRepository produtoRepository,
                           PedidoRepository pedidoRepository) {
        this.carrinhoRepository = carrinhoRepository;
        this.produtoRepository = produtoRepository;
        this.pedidoRepository = pedidoRepository;
    }


    private PedidoEntity buscarPedidoId(Long pedidoId) {
        return pedidoRepository.findById(pedidoId)
                .orElseThrow(() -> new RuntimeException("pedido não encontrado"));
    }


    private ProdutoEntity buscarProdutoId(Long produtoId) {
        return produtoRepository.findById(produtoId)
                .orElseThrow(() -> new RuntimeException("produto não encontrado"));
    }

    // descobrir se o item já existe no pedido
    private Optional<CarrinhoEntity> buscarItemId(Long pedidoId, Long produtoId) {
        return carrinhoRepository.findByPedidoIdAndProdutoId(pedidoId, produtoId);
    }


    public CarrinhoResponse editarCarrinho(Long pedidoId, Long produtoId, Integer quantidade) {

        buscarPedidoId(pedidoId);   // valida se pedido existe

        ProdutoEntity produto = buscarProdutoId(produtoId);

        Optional<CarrinhoEntity> item = buscarItemId(pedidoId, produtoId);


        BigDecimal precoUnit = produto.getPreco();


        CarrinhoEntity carrinho;

        if (item.isPresent()) {
            carrinho = item.get();  // se item existir passo pra carrinho (facilita return padrão)

            carrinho.setQuantidade(carrinho.getQuantidade() + quantidade);

            if (carrinho.getQuantidade() < 0) {
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST
                );
            }

        }
        else{
            carrinho = new CarrinhoEntity();

            if (quantidade < 1) {
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST
                );
            }

            carrinho.setQuantidade(quantidade);
        }


        carrinho.setPedidoId(pedidoId);
        carrinho.setProdutoId(produtoId);
        carrinho.setPrecoUnit(precoUnit);
        carrinho.setPrecoTotal(carrinho.getPrecoUnit().multiply(new BigDecimal(carrinho.getQuantidade())));

        carrinhoRepository.save(carrinho);


        return new CarrinhoResponse(
            carrinho.getId(),
            carrinho.getPedidoId(),
            carrinho.getProdutoId(),
            carrinho.getQuantidade(),
            carrinho.getPrecoUnit(),
            carrinho.getPrecoTotal()
        );

    }

}