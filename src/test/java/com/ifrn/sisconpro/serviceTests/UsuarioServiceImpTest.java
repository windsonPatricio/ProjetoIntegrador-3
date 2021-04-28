package com.ifrn.sisconpro.serviceTests;

import com.ifrn.sisconpro.SisconproApplication;
import com.ifrn.sisconpro.model.Usuario;
import com.ifrn.sisconpro.model.factory.UsuarioFactory;
import com.ifrn.sisconpro.repository.UsuarioRepository;
import com.ifrn.sisconpro.service.serviceImple.UsuarioServiceImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = SisconproApplication.class)
public class UsuarioServiceImpTest {

    @MockBean
    UsuarioRepository repository;

    @Autowired
    UsuarioServiceImp service;

    @Autowired
    UsuarioFactory uf;

//    private List<Usuario> usuarios;
    private String matriculaUser;
    private Usuario user1;

    @BeforeEach
    public void setup(){

//        this.usuarios = new LinkedList<>();
        this.user1 = uf.criarUsuario(
                "20211303",
                "Windson Patricio",
                "2",
                "Contabilidade",
                "32822345",
                "12345"
        );
//        Usuario user2 = uf.criarUsuario(
//                "20211304",
//                "Wilson Patricio",
//                "2",
//                "Contabilidade",
//                "32822346",
//                "54321"
//        );

//        this.usuarios.add(user1);
//        this.usuarios.add(user2);

        this.matriculaUser = this.user1.getMatricula();
    }

    @Test
    public void testServiceNaoENulo(){
        assertThat(this.service).isNotNull();
    }

    @Test
    public void testFindByMatricula(){

        doReturn(this.user1)
                .when(repository)
                .findByMatricula(this.matriculaUser);

        Usuario usuarioRetornado = service.findByMatricula(this.matriculaUser);

        assertThat(usuarioRetornado).isEqualTo(this.user1);

    }

}
