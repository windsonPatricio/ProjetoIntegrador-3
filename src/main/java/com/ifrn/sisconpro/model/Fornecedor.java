package com.ifrn.sisconpro.model;


import lombok.*;

import javax.persistence.*;

//ANOTACAO JPA
@Entity
@Table(name="TB_FORNECEDOR")
@Embeddable

//ANOTACAO LOMBOK
@Builder(toBuilder = true)
@Data
@NoArgsConstructor
//@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "cnpj", nullable = false)
    private String cnpj;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "ramo", nullable = false)
    private String ramo;

    @Column(name = "endereco")
    private String endereco;

    @Column(name = "telefone", nullable = false)
    private String telefone;

}