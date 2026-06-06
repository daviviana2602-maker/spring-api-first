package br.com.davi.spring_boot_first.repository;

import br.com.davi.spring_boot_first.entity.CarrinhoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface CarrinhoRepository extends JpaRepository<CarrinhoEntity, Long> {

    Optional<CarrinhoEntity> findByPedidoIdAndProdutoId(Long pedidoId, Long produtoId);

}