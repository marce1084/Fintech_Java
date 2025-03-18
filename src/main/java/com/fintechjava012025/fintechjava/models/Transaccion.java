package com.fintechjava012025.fintechjava.models;

import java.time.LocalDateTime;
import java.util.Date;

public class Transaccion {
    private final Long id;
    private final Double monto;
    private final LocalDateTime fecha;
    private final String tipo;
    private final String motivo;
    private final Cuenta cuenta;

    //Contructor con validación
    public Transaccion(Long id, Double monto, LocalDateTime fecha, String tipo, String motivo, Cuenta cuenta) {
        if (id == null || id <= 0 ) {
            throw new IllegalArgumentException("Id inválido. Debe ser mayor que 0");
        }
        if (monto == null || monto <= 0 ) {
            throw new IllegalArgumentException("Cantidad inválida. Debe ser mayor que 0");
        }
        if (fecha == null) {
            throw new IllegalArgumentException("Fecha inválida. No puede ser nula");
        }
        if (!validarTipo(tipo)) {
            throw new IllegalArgumentException("Tipo válido. Debe ser 'Depósito' o 'Retiro'");
        }
        if (cuenta == null) {
            throw new IllegalArgumentException("La cuenta no puede ser nula");
        }

        this.id = id;
        this.monto = monto;
        this.fecha = fecha;
        this.tipo = tipo;
        this.motivo = motivo;
        this.cuenta = cuenta;
    }

    //Getters
    /*No se agregan setters porque el objeto Transacción es una transacción bancaria
    y en este caso, garantiza q una vez creado el objeto, sus valores no puedan modificarse,
    lo cual es lo ideal para una transacción bancaria.*/

    public Long getId() {
        return id;
    }

    public Double getMonto() {
        return monto;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public String getMotivo() {
        return motivo;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    // Métodos de validación privados
    public boolean validarTipo(String tipo) {
        return tipo != null && (tipo.equals("Depósito") || tipo.equals("Retiro"));
    }
    //Metodo para validar el monto (por ej.: deber ser mayor a cero)
    public boolean validarMonto(Double monto) {
        return monto != null && monto >= 0;
    }
   /* //Metodo para validar la fecha
    public boolean validarFecha(Date fecha) {
        return fecha != null && fecha.before(getFecha());
    }
    //Metodo para validar el motivo
    public boolean validarMotivo(String motivo) {
        return motivo != null && motivo.length() > 0;
    }*/

    // Metodo Factory para crear una nueva transacción basada en otra, modificando solo lo necesario.
    /*Se genera una nueva instancia de Transaccion basada en una existente.
    * el id, fecha y tipo permanecen iguales, solo se puede cambiar cantidad y motivo*/
    public Transaccion nuevaTransaccion(Double nuevomonto, String nuevomotivo) {
        return new Transaccion(this.id, nuevomonto, LocalDateTime.now(), this.tipo, nuevomotivo, this.cuenta);
    }

}
