package com.ifrn.sisconpro.service.serviceImple;

import com.ifrn.sisconpro.model.Usuario;
import com.ifrn.sisconpro.repository.UsuarioRepository;
import com.ifrn.sisconpro.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UsuarioServiceImp implements UsuarioService {

    @Autowired
    UsuarioRepository repository;

    @Override
    public List<Usuario> findAll() {
        return repository.findAll();
    }

    @Override
    public Usuario findById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Usuario findByMatricula(String matircula) {
        return null;
    }

    @Override
    public Usuario save(Usuario usuario) {
        return repository.save(usuario);
    }

}
