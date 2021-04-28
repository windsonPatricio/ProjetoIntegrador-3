package com.ifrn.sisconpro.repository;

import com.ifrn.sisconpro.model.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FornecerdorRepository extends JpaRepository<Fornecedor, Long> {
}
