package br.com.davi.spring_boot_first.repository;

import br.com.davi.spring_boot_first.entity.ConcluidosEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ConcluidosRepository extends JpaRepository<ConcluidosEntity, Long> {
}