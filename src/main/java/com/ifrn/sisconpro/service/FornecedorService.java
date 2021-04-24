package com.ifrn.sisconpro.service;

import com.ifrn.sisconpro.model.Contrato;
import com.ifrn.sisconpro.model.Fornecedor;

import java.util.List;

public interface FornecedorService {

    List<Fornecedor> findAll();
    Fornecedor findById(Long id);
    Fornecedor save(Fornecedor fornecedor);
    void deleteById(Long id);
}
