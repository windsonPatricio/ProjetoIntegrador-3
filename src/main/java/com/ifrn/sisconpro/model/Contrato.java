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

    @Column(name = "numero")
    private String numero;

    @ManyToOne
    @JoinColumn(name = "idContratoFornecedor")
    private Fornecedor nomeFornercedor;

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


    //  private contStatus status;

    @Column(name = "fonteRecurso")
    private String fonteRecurso;

    @Column(name = "dataInicioVigencia")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataInicioVigencia;

    @Column(name = "dataFimlVigencia")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate dataFimVigencia;

    @Column(name = "arquivo")
    private File arquivo;

    @Column(name = "Status")
    private int status;


}

