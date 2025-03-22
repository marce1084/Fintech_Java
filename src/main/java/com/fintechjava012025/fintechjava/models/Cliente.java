package com.fintechjava012025.fintechjava.models;

import jakarta.validation.constraints.*;
import jakarta.persistence.*;
import java.util.List;

public class Cliente {
    //Atributos
    @NotNull(message = "El DNI no puede ser nulo")
    @Positive(message = "El DNI deber ser major que 0")
    private Long DNI;

    @NotNull(message = "El nombre no puede estar vacío")
    @Size(min = 3, max = 50, message = "El nombre debe tener entre 3 y 100 caracteres")
    private String nombre;

    @NotNull(message = "El apellido no puede estar vacío")
    @Size(min = 3, max = 50, message = "El apellido debe tener entre 3 y 100 caracteres")
    private String apellido;

    @NotNull(message = "El correo no puede estar vacío")
    @Email(message = "Debe proporcionar un correo electrónico válido")
    private String mail;

    @NotNull(message = "La contraseña no puede estar vacía")
    @Size(min = 8, max = 20, message = "La contraseña debe tener entre 8 y 20 caracteres")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{8,}$",
    message = "La contraseña debe incluir al menos una mayúscula, una minúscula, un número y un carácter especial")
    private String contrasenia;

    //Constructur vacío (necesario para jpa)
    public void Cliente() {}

    //Constructor con los atributos
    public Cliente(Long DNI, String nombre, String apellido, String mail, String contrasenia) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellido = apellido;
        this.mail = mail;
        this.contrasenia = contrasenia;
    }

    //Getters y Setters
    public Long getDNI() {
        return DNI;
    }
    public void setDNI(Long dni) {
        this.DNI = dni;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
    public String getContrasenia() {
        return contrasenia;
    }
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

}
