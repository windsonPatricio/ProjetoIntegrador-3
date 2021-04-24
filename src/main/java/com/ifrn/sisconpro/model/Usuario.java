package com.ifrn.sisconpro.model;


import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;

//ANOTACAO JPA
@Entity
@Table(name="TB_USUARIO")
@Embeddable

//ANOTACAO LOMBOK
@NoArgsConstructor
@Builder(toBuilder = true)
@Data
@AllArgsConstructor
@Setter
@Getter

public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "matricula", nullable = false, unique = true)
    private String matricula;

    @Column(name = "nome", nullable = false)
    private String nome;

    //private tipoUsuario tipo;

    @Column(name = "setor", nullable = false)
    private String setor;

    @Column(name = "telefone", nullable = false)
    private String telefone;

    @Column(name = "senha", nullable = false)
    private String senha;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.matricula;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}