package com.ifrn.sisconpro.model.factory;

import com.ifrn.sisconpro.model.Departamento;
import com.ifrn.sisconpro.model.Protocolos;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.File;
import java.util.Date;

@Component
public class ProtocolosFactory {

    public Protocolos criarProtocolo(
            String numero, String usuario,
            String assunto, String assuntoDetalhes, String status){

        Protocolos protocolo = Protocolos.builder()
                .numero(numero)
                .usuario(usuario)
                .assunto(assunto)
                .assuntoDetalhes(assuntoDetalhes)
                .status(status)
                .build();

        return protocolo;
    }
}
