package com.ifrn.sisconpro.model.factory;

import com.ifrn.sisconpro.model.Usuario;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;



@Component
public class UsuarioFactory {

    public Usuario criarUsuario(
            String matricula, String nome,
            String tipoUsuario, String setor, String telefone,
            String senha){

        Usuario user = Usuario.builder()
                .matricula(matricula)
                .nome(nome)
                .tipoUsuario(Usuario.verificarTipoDeUsuario(tipoUsuario))
                .setor(setor)
                .telefone(telefone)
                .senha(new BCryptPasswordEncoder().encode(senha))
                .build();

        return user;
    }
}














