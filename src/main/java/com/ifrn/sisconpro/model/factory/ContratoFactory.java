package com.ifrn.sisconpro.model.factory;

import com.ifrn.sisconpro.model.Contrato;
import com.ifrn.sisconpro.model.Fornecedor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.File;
import java.util.Date;

@Component
public class ContratoFactory {

    public Contrato criarContrato(String numero, String cnpj, String razaoSocial,
                  String tipoContrato, String unidadeBeneficiaria, Double valorInicial,
                  String modalidade, String objetoContrato, String fonteRecurso, String status){

                  Contrato contrato = Contrato.builder()
                          .numero(numero)
                          .cnpj(cnpj)
                          .razaoSocial(razaoSocial)
                          .tipoContrato(tipoContrato)
                          .unidadeBeneficiaria(unidadeBeneficiaria)
                          .valorInicial(valorInicial)
                          .modalidade(modalidade)
                          .objetoContrato(objetoContrato)
                          .fonteRecurso(fonteRecurso)
                          .status(status)
                          .build();

                  return contrato;

    }
}
