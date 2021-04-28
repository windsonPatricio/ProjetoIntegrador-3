package com.ifrn.sisconpro.serviceTests;

import com.ifrn.sisconpro.model.Protocolos;
import com.ifrn.sisconpro.model.factory.ProtocolosFactory;
import com.ifrn.sisconpro.repository.ProtocoloRepository;
import com.ifrn.sisconpro.service.serviceImple.ProtocoloServiceImple;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;

@SpringBootTest
public class ProtocoloServiceImpleTest {

//    @MockBean
//    ProtocoloRepository repository;

    @MockBean
    ProtocoloServiceImple service;

    @Autowired
    ProtocolosFactory pf;

    private List<Protocolos> protocolos;

    @BeforeEach
    public void setup(){

        this.protocolos = new LinkedList<>();
        Protocolos prot1 = pf.criarProtocolo(
                "123",
                "20211304",
                "Teste1",
                "Testando protocolos 1",
                "2"
        );
        Protocolos prot2 = pf.criarProtocolo(
                "456",
                "20211304",
                "Teste2",
                "Testando protocolos 2",
                "3"
        );

        this.protocolos.add(prot1);
        this.protocolos.add(prot2);

    }

    @Test
    public void testServiceNaoENulo(){
        assertThat(this.service).isNotNull();
    }

    @Test
    public void testContarProtocolosRecebidos(){

        doReturn(this.protocolos)
                .when(this.service)
                .contarProtocolosRecebidos();

        Iterable<Protocolos> protocolosRetornados =
                this.service.contarProtocolosRecebidos();

        assertThat(protocolosRetornados).containsExactlyElementsOf(this.protocolos);

    }

    @Test
    public void testContarProtocolosEnviados(){

        doReturn(this.protocolos)
                .when(this.service)
                .contarProtocolosEnviados();

        Iterable<Protocolos> protocolosRetornados =
                this.service.contarProtocolosEnviados();

        assertThat(protocolosRetornados).containsExactlyElementsOf(this.protocolos);

    }

}
