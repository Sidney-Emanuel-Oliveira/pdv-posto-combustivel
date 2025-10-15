package com.br.pdvpostocombustivel.domain.entity;
<<<<<<< HEAD

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "acessos")
public class Acesso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(unique = true)
    private String usuario;

    @NotBlank
=======
public class Acesso {
    /*atributos*/
    private String usuario;
>>>>>>> 6d2f50b40b505747430fffd2cc8bd0c5b5f2de93
    private String senha;

    /*constructor*/
    public Acesso(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }
    public Acesso() {

        super();
    }

    /*getters*/
<<<<<<< HEAD
    public Long getId() {
        return id;
    }

=======
>>>>>>> 6d2f50b40b505747430fffd2cc8bd0c5b5f2de93
    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }

    /*setters*/
<<<<<<< HEAD
    public void setId(Long id) {
        this.id = id;
    }

=======
>>>>>>> 6d2f50b40b505747430fffd2cc8bd0c5b5f2de93
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}