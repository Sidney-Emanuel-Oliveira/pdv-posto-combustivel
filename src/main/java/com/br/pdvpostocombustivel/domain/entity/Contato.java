package com.br.pdvpostocombustivel.domain.entity;
<<<<<<< HEAD

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "contatos")
public class Contato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String telefone;

    @NotBlank
    @Email
    private String email;

    @NotBlank
=======
public class Contato {
    /*atributos */
    private String telefone;
    private String email;
>>>>>>> 6d2f50b40b505747430fffd2cc8bd0c5b5f2de93
    private String endereco;

    /*constructor*/
    public Contato(String telefone, String email, String endereco){
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }

<<<<<<< HEAD
    public Contato() {

        super();
    }
    /*getters*/
    public Long getId() {
        return id;
    }

=======
    /*getters*/
>>>>>>> 6d2f50b40b505747430fffd2cc8bd0c5b5f2de93
    public String getTelefone() {
        return telefone;
    }
    public String getEmail() {
        return email;
    }
    public String getEndereco() {
        return endereco;
    }
<<<<<<< HEAD

    /*setters*/
    public void setId(Long id) {
        this.id = id;
    }

=======
    public Contato() {

        super();
    }
    /*setters*/
>>>>>>> 6d2f50b40b505747430fffd2cc8bd0c5b5f2de93
    public void setTelefone (String telefone){
        this.telefone = telefone;
    }
    public void setEmail (String email){
        this.email = email;
    }
    public void setEndereco (String endereco){
        this.endereco = endereco;
    }
}