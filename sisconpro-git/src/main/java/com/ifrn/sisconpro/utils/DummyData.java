package com.ifrn.sisconpro.utils;

import com.ifrn.sisconpro.model.Contrato;
import com.ifrn.sisconpro.repository.ContratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

@Component
public class DummyData {
/*

    @Autowired
    ContratoRepository repository;


    // O método vai sendo executado conforme a aplicação vai subindo
    //
    //



        @PostConstruct
        public void salvarContrato(){

            List<Contrato> contrato = new LinkedList<>();

            // Ocorrencia 1

            Contrato acao3 = Contrato.builder()

                    .nome("Wilson")
                    .numero(30)
                    .fonteRecurso("BNDES")
                    .dataFinalVigência(LocalDate.of(2021,05,05))
                    .dataInicioVigencia(LocalDate.of(2021,03,01))
                    .valorInicial(500.00)
                    .build();


            Contrato acao4 = Contrato.builder()

                    .nome("WINDSON")
                    .numero(34)
                    .fonteRecurso("PARTICIPATIVO")
                    .dataFinalVigência(LocalDate.of(2021,05,05))
                    .dataInicioVigencia(LocalDate.of(2021,03,01))
                    .valorInicial(50.00)
                    .build();

            contrato.add(acao3);
            contrato.add(acao4);

            for (Contrato lista : contrato) {
                Contrato listaContrato = repository.save(lista);
                System.out.println("[SAIDA] ID: " + listaContrato.getId());
            }

        }*/

    }

