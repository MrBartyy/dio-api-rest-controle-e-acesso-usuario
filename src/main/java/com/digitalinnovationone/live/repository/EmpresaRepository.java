package com.digitalinnovationone.live.repository;

import com.digitalinnovationone.live.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
}
