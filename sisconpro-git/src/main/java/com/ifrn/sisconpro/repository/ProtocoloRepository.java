package com.ifrn.sisconpro.repository;

import com.ifrn.sisconpro.model.Protocolos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ProtocoloRepository extends JpaRepository<Protocolos, Long>, QuerydslPredicateExecutor<Protocolos> {
}
