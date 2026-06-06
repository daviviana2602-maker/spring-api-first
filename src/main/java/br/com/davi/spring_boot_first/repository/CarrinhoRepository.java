package br.com.davi.spring_boot_first.repository;

import br.com.davi.spring_boot_first.entity.CarrinhoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface CarrinhoRepository extends JpaRepository<CarrinhoEntity, Long> {

    Optional<CarrinhoEntity> findByPedidoIdAndProdutoId(Long pedidoId, Long produtoId);

    List<CarrinhoEntity> findByPedidoId(Long pedidoId);

}