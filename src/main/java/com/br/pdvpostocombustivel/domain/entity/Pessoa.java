package com.br.pdvpostocombustivel.domain.entity;

import com.br.pdvpostocombustivel.enums.TipoPessoa;
import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name = "pessoa")

public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200, nullable = false)
    private String nomeCompleto;

    @Column(length = 14, nullable = false)
    private String cpfCnpj;

    @Column(length = 12)
    private Long numeroCtps;

    @Column(length = 10, nullable = false)
    private LocalDate dataNascimento;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_pessoa", nullable = false, length = 15)
    private TipoPessoa tipoPessoa;


    /** atributos */
    // construtor
    public Pessoa(String nomeCompleto,
                  String cpfCnpj,
                  Long numeroCtps,
                  LocalDate dataNascimento,
                  TipoPessoa tipoPessoa) {
        this.numeroCtps = numeroCtps;
        this.dataNascimento = dataNascimento;
        this.nomeCompleto = nomeCompleto;
        this.cpfCnpj = cpfCnpj;
        this.tipoPessoa = tipoPessoa;
    }
    public Pessoa() {

        super();
    }


    // getters
    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public Long getNumeroCtps() {
        return numeroCtps;
    }
    public TipoPessoa getTipoPessoa() {
        return tipoPessoa;
    }

    // setters
    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setNumeroCtps(Long numeroCtps) {
        this.numeroCtps = numeroCtps;
        }
    public void setTipoPessoa(TipoPessoa tipoPessoa){
        this.tipoPessoa = tipoPessoa;
    }
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }
    }

