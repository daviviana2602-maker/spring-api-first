package br.com.davi.spring_boot_first.repository;

import br.com.davi.spring_boot_first.entity.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PedidoRepository extends JpaRepository<PedidoEntity, Long> {

    List<PedidoEntity> findByUsuarioId(Long usuarioId);

}