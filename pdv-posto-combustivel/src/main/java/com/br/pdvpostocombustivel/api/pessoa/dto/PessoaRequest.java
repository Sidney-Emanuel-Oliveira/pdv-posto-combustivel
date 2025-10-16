package com.br.pdvpostocombustivel.api.pessoa.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;

public class PessoaRequest {

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

    public PessoaRequest() {}

    public PessoaRequest(String nomeCompleto, String cpfCnpj, Long numeroCtps, LocalDate dataNascimento, String tipoPessoa) {
        this.nomeCompleto = nomeCompleto;
        this.cpfCnpj = cpfCnpj;
        this.numeroCtps = numeroCtps;
        this.dataNascimento = dataNascimento;
        this.tipoPessoa = tipoPessoa;
    }

    // Getters e Setters
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
