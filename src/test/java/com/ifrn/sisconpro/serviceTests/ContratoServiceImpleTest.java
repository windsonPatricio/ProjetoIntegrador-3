package com.ifrn.sisconpro.serviceTests;

import com.ifrn.sisconpro.model.Contrato;
import com.ifrn.sisconpro.model.Protocolos;
import com.ifrn.sisconpro.service.serviceImple.ContratoServiceImple;
import com.ifrn.sisconpro.model.factory.ContratoFactory;
import com.ifrn.sisconpro.repository.ContratoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;

@SpringBootTest
public class ContratoServiceImpleTest {

//    @MockBean
//    ContratoRepository repository;

    @MockBean
    ContratoServiceImple service;

    @Autowired
    ContratoFactory cf;

    private List<Contrato> contratos;

    @BeforeEach
    public void setup(){

        this.contratos = new LinkedList<>();

        Contrato contrato1 = cf.criarContrato(
                "33333",
                "234455678890/900",
                "Teste1",
                "Locação",
                "Teste2",
                250.0,
                "Testando",
                "Teste de Intregação",
                "IFRN",
                "1"
        );

        Contrato contrato2 = cf.criarContrato(
                "22222",
                "32454346546/455",
                "Teste2",
                "Transporte",
                "Teste1",
                300.0,
                "Testando",
                "Teste de Intregação",
                "IFRN",
                "2"
        );

        this.contratos.add(contrato1);
        this.contratos.add(contrato2);
    }

    @Test
    public void testServiceNaoENulo(){
        assertThat(this.service).isNotNull();
    }

    @Test
    public void testContarContratosConfirmados(){

        doReturn(this.contratos)
                .when(this.service)
                .contarContratosConfirmados();

        Iterable<Contrato> contratosRetornados =
                this.service.contarContratosConfirmados();

        assertThat(contratosRetornados).containsExactlyElementsOf(this.contratos);

    }
}
