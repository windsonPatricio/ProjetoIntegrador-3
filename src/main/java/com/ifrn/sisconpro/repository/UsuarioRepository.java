package com.ifrn.sisconpro.repository;

import com.ifrn.sisconpro.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
