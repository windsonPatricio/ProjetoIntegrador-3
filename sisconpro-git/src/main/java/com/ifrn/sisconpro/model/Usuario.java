package com.ifrn.sisconpro.model;


import lombok.*;

import javax.persistence.*;

//ANOTACAO JPA
@Entity
@Table(name="TB_USUARIO")
@Embeddable

//ANOTACAO LOMBOK
@Builder(toBuilder = true)
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "nome", nullable = false)
    private String nome;

   // private tipoUsuario tipo;

    @Column(name = "setor", nullable = false)
    private String setor;

    @Column(name = "telefone", nullable = false)
    private String telefone;

}