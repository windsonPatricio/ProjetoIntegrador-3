package com.ifrn.sisconpro.service;

import com.ifrn.sisconpro.model.Usuario;

import java.util.List;

public interface UsuarioService {

    List<Usuario> findAll();
    Usuario findById(Long id);
    Usuario findByMatricula(String matircula);
    Usuario save(Usuario usuario);
    void deleteById(Long id);
}
