package com.ifrn.sisconpro.service;

import com.ifrn.sisconpro.model.Contrato;

import java.util.List;

public interface ContratoService {


    List<Contrato> findAll();
    Contrato findById(Long id);
    Contrato save(Contrato contrato);
    void deleteById(Long id);



    Iterable<Contrato> listarContratoProximoVencimento();
    Iterable<Contrato> contarContratosConfirmados();


}