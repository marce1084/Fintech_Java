package com.fintechjava012025.fintechjava.models;

import com.sun.istack.internal.NotNull;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;

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


}
