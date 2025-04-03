package com.fintechjava012025.fintechjava.models;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;
import java.util.Date;

public class Transaccion {
    @NotNull(message = "El ID no puede ser nulo")
    @Positive(message = "El ID deber ser mayor que 0")
    private final Long id;

    @NotNull(message = "El monto no puede ser nulo")
    @Positive(message = "El monto debe ser mayor que 0")
    private final Double monto;

    @NotNull(message = "La fecha no puede ser nula")
    @PastOrPresent(message = "La fecha deber ser igual o anterior a la fecha actual")
    private final LocalDateTime fecha;

    @NotNull(message = "El tipo no puede ser nulo")
    @Pattern(regexp = "Depósito|Retiro", message = "El tipo deber ser 'Depósito' o 'Retiro'")
    private final String tipo;

    @NotNull(message = "El motivo no puede ser nulo")
    @Size(min = 1, message = "El motivo no puede estar vacío")
    private final String motivo;

    @ManyToOne
    @JoinColumn(name = "cuenta_id", nullable = false)
    private final Cuenta cuenta;

    //Contructor con validación
    public Transaccion(Long id, Double monto, LocalDateTime fecha, String tipo, String motivo, Cuenta cuenta) {
        //Implemantamos validaciones
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("ID de transacción inválido");
        }
        if (monto == null || monto <= 0) {
            throw new IllegalArgumentException("El monto no puede ser nulo");
        }
        if (fecha == null || fecha.isAfter(LocalDateTime.now())) {
            throw new IllegalArgumentException("Fecha inválida");
        }
        if (tipo == null || tipo.trim().isEmpty()) {
            throw new IllegalArgumentException("Tipo de transacción requerido");
        }
        if (cuenta == null) {
            throw new IllegalArgumentException("Cuenta asociada requerida");
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

   // Metodo Factory para crear una nueva transacción basada en otra, modificando solo lo necesario.
    /*Se genera una nueva instancia de Transaccion basada en una existente.
    * el id, fecha y tipo permanecen iguales, solo se puede cambiar cantidad y motivo*/
    public Transaccion nuevaTransaccion(Double nuevomonto, String nuevomotivo) {
        return new Transaccion(this.id, nuevomonto, this.fecha, this.tipo, nuevomotivo, this.cuenta);
    }

}
