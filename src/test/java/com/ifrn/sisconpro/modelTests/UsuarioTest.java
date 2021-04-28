package com.ifrn.sisconpro.modelTests;

import com.ifrn.sisconpro.model.Usuario;
import com.ifrn.sisconpro.model.factory.UsuarioFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class UsuarioTest {

    Usuario user1;

    @Before
    public void setUp(){
        this.user1 = Usuario.builder()
                .matricula("20211302")
                .nome("Fábio Miguel")
                .setor("CTI")
                .telefone("32824544")
                .senha("12345")
                .build();

    }

    @Test
    public void testVerificarTipoDeUsuario(){
        this.user1.setTipoUsuario(Usuario.verificarTipoDeUsuario("2"));
        String tipo = this.user1.getTipoUsuario();
        assertEquals("USER",tipo);
    }

}
