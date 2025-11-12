package br.com.PdvFrontEnd.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

public class PrecoResponse {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("valor")
    private BigDecimal valor;

    @JsonProperty("dataAlteracao")
    private String dataAlteracao;

    @JsonProperty("horaAlteracao")
    private String horaAlteracao;

    public PrecoResponse() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(String dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    public String getHoraAlteracao() {
        return horaAlteracao;
    }

    public void setHoraAlteracao(String horaAlteracao) {
        this.horaAlteracao = horaAlteracao;
    }
}
