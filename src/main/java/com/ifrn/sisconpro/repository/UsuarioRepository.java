package com.ifrn.sisconpro.repository;

import com.ifrn.sisconpro.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByMatricula(String matricula);
}
