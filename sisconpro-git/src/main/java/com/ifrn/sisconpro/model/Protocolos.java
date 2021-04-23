package com.ifrn.sisconpro.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.File;
import java.util.Date;

//ANOTACAO JPA
@Entity
@Table(name="TB_PROTOCOLOS")
@Embeddable

//ANOTACAO LOMBOK
@Builder(toBuilder = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class Protocolos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "numero", nullable = false)
    private String numero;

    @ManyToOne
    @JoinColumn(name = "idProtocoloDepartamentoOrigem")
    private Departamento nomeDepartamentoOrigem;

    @ManyToOne
    @JoinColumn(name = "idProtocoloDepartamentoDestino")
    private Departamento nomeDepartamentoDestino;

    @Column(name = "dataEnvio")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataEnvio;

    //   private statusProtocolo status;
    //   private tipoConteudo identificacao;

    @Column(name = "usuario", nullable = false)
    private String usuario;

    @Column(name = "assunto", nullable = false)
    private String assunto;

    @Column(name = "assuntoDetalhes", nullable = false)
    private String assuntoDetalhes;

    @Column(name = "arquivo", nullable = false)
    private File arquivo;

    @Column(name = "Status")
    private int status;


}
