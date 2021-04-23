package com.ifrn.sisconpro.service.serviceImple;

import com.ifrn.sisconpro.model.Protocolos;
import com.ifrn.sisconpro.model.QProtocolos;
import com.ifrn.sisconpro.repository.ProtocoloRepository;
import com.ifrn.sisconpro.service.ProtocoloService;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class ProtocoloServiceImple implements ProtocoloService {

    @Autowired
    ProtocoloRepository repository;

    @Autowired
    EntityManager manager;

    @Override
    public List<Protocolos> findAll() {
        return repository.findAll();
    }

    @Override
    public Protocolos findById(Long id) {
        // findById() retorna um Option, para obter o Produto é necessário
        // adicionar o .get()
        return repository.findById(id).get();
    }

    @Override
    public Protocolos save(Protocolos protocolo) {
        return repository.save(protocolo);
    }

    @Override
    public void deleteById(Long id) { repository.deleteById(id); }

    @Override
    public Iterable<Protocolos> contarProtocolosRecebidos(){
        QProtocolos qProtocolos = QProtocolos.protocolos;
        BooleanExpression listaDeRecebidos = qProtocolos.status.eq(2);

        return repository.findAll(listaDeRecebidos);
    }

    @Override
    public Iterable<Protocolos> contarProtocolosEnviados(){
        QProtocolos qProtocolos = QProtocolos.protocolos;
        BooleanExpression listaDeEnviados = qProtocolos.status.eq(3);
        return repository.findAll(listaDeEnviados);
    }

}
