package com.fintechjava012025.fintechjava.models;

import com.sun.istack.internal.NotNull;
import org.apache.logging.log4j.message.Message;
import org.hibernate.annotations.BatchSize;
import jakarta.validation.constraints.Email;

public class Cliente {
    //Atributos
    @NotNull(String Message = "El DNI no puede estar vacío")
    Long DNI;
    @NotNull(String Message = "El nombre no puede estar vacío")
    @BatchSize(size = 0)
    int min(3), int max(100), String Message = "El nombre debe tener entre 3 y 100 caracteres"
    String nombre;
    @BatchSize(size = 0)
    int min(3), int max(100), String Message = "El apellido debe tener entre 3 y 100 caracteres"
    String apellido;
    @NotNull(String Message = "El correo no puede estar vacío")
    @Email (String Message = "Debe proporcionar un mail válido")
    String mail;

    String Contraseña;

    //Constructur vacío (necesario para jpa)
}
