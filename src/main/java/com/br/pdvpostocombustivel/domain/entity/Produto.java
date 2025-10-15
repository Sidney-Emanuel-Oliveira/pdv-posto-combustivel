package com.br.pdvpostocombustivel.domain.entity;

<<<<<<< HEAD
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

=======
public class Produto {

    // atributos
>>>>>>> 6d2f50b40b505747430fffd2cc8bd0c5b5f2de93
    private String nome;
    private String referencia;
    private String fornecedor;
    private String categoria;
    private String marca;

<<<<<<< HEAD
    // Construtor existente
=======
    // construtor
>>>>>>> 6d2f50b40b505747430fffd2cc8bd0c5b5f2de93
    public Produto(String nome, String referencia, String fornecedor, String categoria, String marca) {
        this.nome = nome;
        this.referencia = referencia;
        this.fornecedor = fornecedor;
        this.categoria = categoria;
        this.marca = marca;
    }

<<<<<<< HEAD
    public Produto() {
        super();
    }

    // Getter e Setter para ID
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getters e setters existentes
=======
    // getters
>>>>>>> 6d2f50b40b505747430fffd2cc8bd0c5b5f2de93
    public String getNome() {
        return nome;
    }

<<<<<<< HEAD
    public void setNome(String nome) {
        this.nome = nome;
    }

=======
>>>>>>> 6d2f50b40b505747430fffd2cc8bd0c5b5f2de93
    public String getReferencia() {
        return referencia;
    }

<<<<<<< HEAD
    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

=======
>>>>>>> 6d2f50b40b505747430fffd2cc8bd0c5b5f2de93
    public String getFornecedor() {
        return fornecedor;
    }

<<<<<<< HEAD
    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
=======
    public String getCategoria() {
        return categoria;
    }
    public Produto() {

        super();
>>>>>>> 6d2f50b40b505747430fffd2cc8bd0c5b5f2de93
    }

    public String getMarca() {
        return marca;
    }

<<<<<<< HEAD
=======
    // setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

>>>>>>> 6d2f50b40b505747430fffd2cc8bd0c5b5f2de93
    public void setMarca(String marca) {
        this.marca = marca;
    }
}
