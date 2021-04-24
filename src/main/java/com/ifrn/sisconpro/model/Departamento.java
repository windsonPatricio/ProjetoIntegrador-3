package com.ifrn.sisconpro.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.File;
import java.time.LocalDate;
import java.util.Date;

//ANOTACAO JPA
@Entity
@Table(name="TB_DEPARTAMENTO")
@Embeddable

//ANOTACAO LOMBOK
@Builder(toBuilder = true)
@Data
@NoArgsConstructor
//@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter


public class Departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "codigo")
    private String codigo;


    @Column(name = "nome")
    private String nome;


    @Column(name = "sigla")
    private String sigla;


    @Column(name = "idDepartamentoUsuario")
    private String usuario;

    @Column(name = "telefone")
    private String telefone;


    @Column(name = "email")
    private String email;
}