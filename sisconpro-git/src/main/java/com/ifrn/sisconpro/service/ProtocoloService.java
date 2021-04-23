package com.ifrn.sisconpro.service;

import com.ifrn.sisconpro.model.Protocolos;

import java.util.List;

public interface ProtocoloService {

    List<Protocolos> findAll();
    Protocolos findById(Long id);
    Protocolos save(Protocolos protocolo);
    void deleteById(Long id);


    Iterable<Protocolos> contarProtocolosEnviados();
    Iterable<Protocolos> contarProtocolosRecebidos();
}
