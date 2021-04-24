package com.ifrn.sisconpro.utils;

import com.ifrn.sisconpro.model.Contrato;
import com.ifrn.sisconpro.model.Usuario;
import com.ifrn.sisconpro.repository.ContratoRepository;
import com.ifrn.sisconpro.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

@Component
public class DummyData {

    @Autowired
    UsuarioRepository repository;


    @PostConstruct
    public void salvarUsuario() {

        List<Usuario> users = new LinkedList<>();

        try {
            Usuario user1 = Usuario.builder()
                    .matricula("Admin")
                    .nome("Administrador")
                    .setor("CTI")
                    .telefone("3282-3045")
                    .senha(new BCryptPasswordEncoder().encode("admin"))
                    .build();

            users.add(user1);
            for (Usuario lista : users) {
                Usuario listaUser = repository.save(lista);
                System.out.println("[SAIDA] ID: " + listaUser.getId());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            ;
        }
    }
}

