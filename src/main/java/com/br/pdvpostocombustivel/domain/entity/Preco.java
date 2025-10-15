package com.br.pdvpostocombustivel.domain.entity;

<<<<<<< HEAD
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "precos")
public class Preco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @PositiveOrZero
    private BigDecimal valor;

    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "data_alteracao")
    private Date dataAlteracao;

    @NotNull
    @Temporal(TemporalType.TIME)
    @Column(name = "hora_alteracao")
=======
import java.math.BigDecimal;
import java.util.Date;

public class Preco {

    // atributos
    private BigDecimal valor;
    private Date dataAlteracao;
>>>>>>> 6d2f50b40b505747430fffd2cc8bd0c5b5f2de93
    private Date horaAlteracao;

    // construtor
    public Preco(BigDecimal valor, Date dataAlteracao, Date horaAlteracao) {
        this.valor = valor;
        this.dataAlteracao = dataAlteracao;
        this.horaAlteracao = horaAlteracao;
    }

<<<<<<< HEAD
    public Preco() {

        super();
    }
=======
>>>>>>> 6d2f50b40b505747430fffd2cc8bd0c5b5f2de93

    // getters
    public BigDecimal getValor() {
        return valor;
    }

    public Date getDataAlteracao() {
        return dataAlteracao;
    }

    public Date getHoraAlteracao() {
        return horaAlteracao;
    }
<<<<<<< HEAD

    public Long getId() {
        return id;
=======
    public Preco() {

        super();
>>>>>>> 6d2f50b40b505747430fffd2cc8bd0c5b5f2de93
    }

    // setters
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public void setDataAlteracao(Date dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    public void setHoraAlteracao(Date horaAlteracao) {
        this.horaAlteracao = horaAlteracao;
    }
<<<<<<< HEAD

    public void setId(Long id) {
        this.id = id;
    }
=======
>>>>>>> 6d2f50b40b505747430fffd2cc8bd0c5b5f2de93
}
