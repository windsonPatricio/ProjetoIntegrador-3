package com.ifrn.sisconpro.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.File;
import java.time.LocalDate;
import java.util.Date;

//ANOTACAO JPA
@Entity
@Table(name="TB_CONTRATO")
@Embeddable

//ANOTACAO LOMBOK
@Builder(toBuilder = true)
@Data
@NoArgsConstructor
//@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter


public class Contrato{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "numero", nullable = false, unique = true)
    private String numero;

    @Column(name = "cnpj")
    private String cnpj;

    @Column(name = "razaoSocial")
    private String razaoSocial;

    @Column(name = "tipoContrato")
    private String tipoContrato;

    @Column(name = "UnidadeBeneficiaria")
    private String unidadeBeneficiaria;

    @Column(name = "valorInicial")
    private Double valorInicial;

    @Column(name = "modalidade")
    private String modalidade;

    @Column(name = "objetoContrato")
    private String objetoContrato;


    @Column(name = "fonteRecurso")
    private String fonteRecurso;

    @Column(name = "dataInicioVigencia")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String dataInicioVigencia;

    @Column(name = "dataFimlVigencia")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private String dataFimVigencia;

    @Column(name = "arquivo")
    private File arquivo;

    @Column(name = "Status")
    private String status;

    @Column(name = "dataconvertida")
    private LocalDate dataConvertida;

    public LocalDate converterData(String data){
        LocalDate obj = LocalDate.parse(data);
        return obj;
    }

}

