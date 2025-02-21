package com.fintechjava012025.fintechjava.models;

import com.sun.istack.internal.NotNull;
import jakarta.persistence.*;

import java.util.Date;

public class Transaccion {
    @Id
    private Long id;

    @NotNull
    private Double cantidad;

    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date fecha;

    @NotNull
    private String tipo;

    @NotNull
    private String motivo;

    @ManyToOne
    @JoinColumn(name = "cuenta_id", nullable = false)
    private Cuenta cuenta;

    //Contructor, setters y getters
    public Transaccion() {}

    public Transaccion(Long id, Double cantidad, Date fecha, String tipo, String motivo) {
        this.id = id;
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.tipo = tipo;
        this.motivo = motivo;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Double getCantidad() {
        return cantidad;
    }
    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }
    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getMotivo() {
        return motivo;
    }
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
    public Cuenta getCuenta() {
        return cuenta;
    }
    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

}
