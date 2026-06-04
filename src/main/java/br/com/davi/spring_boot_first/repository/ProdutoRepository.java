package br.com.davi.spring_boot_first.repository;

import br.com.davi.spring_boot_first.entity.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long> {
}