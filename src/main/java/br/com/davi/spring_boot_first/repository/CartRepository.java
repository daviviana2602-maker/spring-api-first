package br.com.davi.spring_boot_first.repository;

import br.com.davi.spring_boot_first.entity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface CartRepository extends JpaRepository<CartEntity, Long> {

    Optional<CartEntity> findByOrderIdAndProductId(Long orderId, Long productId);

    List<CartEntity> findByOrderId(Long orderId);

    void deleteByOrderId(Long orderId);

}