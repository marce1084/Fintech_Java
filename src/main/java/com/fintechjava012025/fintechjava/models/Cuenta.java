package com.fintechjava012025.fintechjava.models;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Cuenta {

    @Id
    private Long id;

    @NotNull
    private Double saldo;

    @NotNull
    private Double saldoInicial;

    @NotBlank
    private String tipoCuenta;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    //Constructor, getters y setters
    public Cuenta() {}

    public Cuenta(Long id, Double saldo, Double saldoInicial, String tipoCuenta) {
        this.id = id;
        this.saldo = saldo;
        this.saldoInicial = saldoInicial;
        this.tipoCuenta = tipoCuenta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Double getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(Double saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
