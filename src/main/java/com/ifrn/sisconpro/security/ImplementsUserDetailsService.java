package com.ifrn.sisconpro.security;

import com.ifrn.sisconpro.model.Usuario;
import com.ifrn.sisconpro.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

@Repository
public class ImplementsUserDetailsService implements UserDetailsService {

    @Autowired
    UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String matricula) throws UsernameNotFoundException {
        Usuario user = repository.findByMatricula(matricula);

        if(user == null){
            throw new UsernameNotFoundException("Usuário inexistente!");
        }

        return user;
    }
}
