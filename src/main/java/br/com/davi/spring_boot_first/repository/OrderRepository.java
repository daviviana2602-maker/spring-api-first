package br.com.davi.spring_boot_first.repository;

import br.com.davi.spring_boot_first.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

    List<OrderEntity> findByUserId(Long userId);

}