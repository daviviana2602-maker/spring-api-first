package br.com.davi.spring_boot_first.database.repository;

import br.com.davi.spring_boot_first.database.entity.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long> {
}