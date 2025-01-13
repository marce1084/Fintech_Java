package com.fintechjava012025.fintechjava.models;

import com.sun.istack.internal.NotNull;
import org.apache.logging.log4j.message.Message;
import org.hibernate.annotations.BatchSize;
import jakarta.validation.constraints.Email;
import org.hibernate.annotations.processing.Pattern;

public class Cliente {
    //Atributos
    @NotNull(String Message = "El DNI no puede estar vacío")
    private Long DNI;

    @NotNull(String Message = "El nombre no puede estar vacío")
    @BatchSize(size = 0)
    int min(3), int max(100), String Message = "El nombre debe tener entre 3 y 100 caracteres"
    private String nombre;

    @BatchSize(size = 0)
    int min(3), int max(100), String Message = "El apellido debe tener entre 3 y 100 caracteres"
    private String apellido;

    @NotNull(String Message = "El correo no puede estar vacío")
    @Email (String Message = "Debe proporcionar un mail válido")
    private String mail;

    @NotNull(String Message = "La contraseña no puede estar vacía")
    @BatchSize(size = 0)
    int min = 8, int max = 20, String message = "La contraseña debe tener entre 8 y 20 caracteres"
    @Pattern(String regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{8,}$",
    String message = "La contraseña debe incluir al menos una mayúscula, una minúscula, un número y un carácter especial")
    private String Contraseña;

    //Constructur vacío (necesario para jpa)
    public void Cliente() {}


}
