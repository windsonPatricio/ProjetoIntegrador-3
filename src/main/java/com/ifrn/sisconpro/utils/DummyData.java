package com.ifrn.sisconpro.utils;

import com.ifrn.sisconpro.model.Contrato;
import com.ifrn.sisconpro.model.Protocolos;
import com.ifrn.sisconpro.model.Usuario;
import com.ifrn.sisconpro.model.factory.ContratoFactory;
import com.ifrn.sisconpro.model.factory.ProtocolosFactory;
import com.ifrn.sisconpro.model.factory.UsuarioFactory;
import com.ifrn.sisconpro.repository.ContratoRepository;
import com.ifrn.sisconpro.repository.ProtocoloRepository;
import com.ifrn.sisconpro.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Component
public class DummyData {

    @Autowired
    ProtocoloRepository repositoryProt;
    ProtocolosFactory pf;

    @Autowired
    UsuarioRepository repository;
    UsuarioFactory uf;

    @Autowired
    ContratoRepository repositoryContrato;
    ContratoFactory cf;

    @PostConstruct
    public void salvarUsuario() {

        List<Usuario> users = new LinkedList<>();
        uf = new UsuarioFactory();

        try {
            Usuario user1 = uf.criarUsuario(
                    "Admin",
                    "Administrador",
                    "1",
                    "CTI",
                    "32823045",
                    "admin"
            );

            Usuario user2 = uf.criarUsuario(
                    "20211303",
                    "Windson Patricio",
                    "2",
                    "Contabilidade",
                    "32822345",
                    "12345"
            );

            Usuario user3 = uf.criarUsuario(
                    "20211304",
                    "Wilson Patricio",
                    "2",
                    "Contabilidade",
                    "32822346",
                    "54321"
            );

            users.add(user1);
            users.add(user2);
            users.add(user3);

            for (Usuario lista : users) {
                Usuario listaUser = repository.save(lista);
                System.out.println("[SAIDA] ID: " + listaUser.getId());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @PostConstruct
    public void salvarProtocolo(){

        LinkedList<Protocolos> protocolo = new LinkedList<>();
        pf = new ProtocolosFactory();

        try {
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

            protocolo.add(prot1);
            protocolo.add(prot2);

            for (Protocolos lista : protocolo) {
                Protocolos listaProtocolo = repositoryProt.save(lista);
                System.out.println("[SAIDA] ID: " + listaProtocolo.getId());
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @PostConstruct
    public void salvarContrato(){

        LinkedList<Contrato> contrato = new LinkedList<>();
        cf = new ContratoFactory();

        try {
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

            contrato.add(contrato1);
            contrato.add(contrato2);

            for (Contrato lista : contrato) {
                Contrato listaContrato = repositoryContrato.save(lista);
                System.out.println("[SAIDA] ID: " + listaContrato.getId());
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}

