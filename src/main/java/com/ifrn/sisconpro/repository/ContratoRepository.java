package com.ifrn.sisconpro.repository;

import com.ifrn.sisconpro.model.Contrato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ContratoRepository extends JpaRepository<Contrato, Long>, QuerydslPredicateExecutor<Contrato> {

}
