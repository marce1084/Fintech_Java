package com.fintechjava012025.fintechjava.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El saldo no debe ser nulo")
    @PositiveOrZero(message = "El saldo no puede ser negativo")
    private Double saldo;

    @NotNull(message = "El saldo inicial no puede ser nulo")
    @PositiveOrZero(message = "El saldo inicial no puede ser negativo")
    private Double saldoInicial;

    @NotBlank(message = "El tipo de cuenta no puede estar vacío")
    private String tipoCuenta;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    //La relación @OneToMany debe ser una lista de transacciones, no una sola transacción.
    // Es recomendable usar mappedBy para indicar que la relación es bidireccional.
    @OneToMany(mappedBy = "cuenta",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Transaccion> transacciones = new ArrayList<>();

    //Constructor vacío
    public Cuenta() {
        this.saldoInicial = 0.0;
    }
    //Constructor con parámetros
    public Cuenta(Long id, Double saldoInicial, String tipoCuenta) {
        this.id = id;
        this.saldo = saldoInicial; //El saldo inicial también es el saldo actual al crear la cuenta
        this.saldoInicial = saldoInicial;
        this.tipoCuenta = tipoCuenta;
    }
    //Setters y Getters
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
    public List<Transaccion> getTransacciones() {
        return transacciones;
    }
    public void setTransaccion(List<Transaccion> transacciones) {
        this.transacciones = transacciones;
    }

    //Metodo depositar
    public void depositar(Double monto, String motivo) {
        if (monto != null && monto > 0) {
            this.saldo += monto; // // "this.saldo" se refiere al atributo de la clase
            //Registrar la transacción
            Transaccion transaccion = new Transaccion(
                    null, //El id se genera automáticamente
                    monto,
                    LocalDateTime.now(), // Fecha y hora de la transacción
                    "Depósito", //Tipo de transacción
                    motivo, // Descripción o motivo de la transacción
                    this // Cuenta asociada a la transacción, hace referencia a la instancia actual de la clase Cuenta
            );
            this.transacciones.add(transaccion);
        } else {
            throw new IllegalArgumentException("El monto a depositar deber ser mayor a 0");
        }
    }

    //Metodo retirar
    public void retirar(Double monto, String motivo) {
        if (monto !=0 && monto > 0 && monto <= this.saldo) {
            this.saldo -= monto;
            //Registrar la transacción
            Transaccion transaccion = new Transaccion(
                    null,
                    monto,
                    LocalDateTime.now(),
                    "Retiro",
                    motivo,
                    this
            );
            this.transacciones.add(transaccion);
        } else {
            throw new IllegalArgumentException("Saldo insuficiente o monto inválido.");
        }
    }

}
