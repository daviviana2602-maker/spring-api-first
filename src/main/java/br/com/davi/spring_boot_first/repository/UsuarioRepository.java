package br.com.davi.spring_boot_first.repository;

import br.com.davi.spring_boot_first.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
}
