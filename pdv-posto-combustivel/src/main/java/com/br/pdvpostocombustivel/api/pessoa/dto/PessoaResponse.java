package com.br.pdvpostocombustivel.api.pessoa.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;

public class PessoaResponse {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("nomeCompleto")
    private String nomeCompleto;

    @JsonProperty("cpfCnpj")
    private String cpfCnpj;

    @JsonProperty("numeroCtps")
    private Long numeroCtps;

    @JsonProperty("dataNascimento")
    private LocalDate dataNascimento;

    @JsonProperty("tipoPessoa")
    private String tipoPessoa;

    public PessoaResponse() {}

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public Long getNumeroCtps() {
        return numeroCtps;
    }

    public void setNumeroCtps(Long numeroCtps) {
        this.numeroCtps = numeroCtps;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(String tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }
}
