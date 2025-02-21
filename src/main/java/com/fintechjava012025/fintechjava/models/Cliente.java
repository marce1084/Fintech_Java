package com.fintechjava012025.fintechjava.models;

import com.sun.istack.internal.NotNull;
//import jakarta.validation.constraints.Size;
import org.apache.logging.log4j.message.Message;
//import org.hibernate.annotations.BatchSize;
//import jakarta.validation.constraints.Email;
import org.hibernate.annotations.processing.Pattern;


public class Cliente {
    //Atributos
    @NotNull //(String Message = "El DNI no puede estar vacío");
    private Long DNI;

    @NotNull //(String Message = "El nombre no puede estar vacío");
    //@BatchSize(size = 0)
    //int min(3), int max(100), String Message = "El nombre debe tener entre 3 y 100 caracteres"
    private String nombre;

    @NotNull
    //@Size (int min(3), int max(100)); //, String Message = "El apellido debe tener entre 3 y 100 caracteres");
    private String apellido;

    @NotNull //(String Message = "El correo no puede estar vacío");
    //@Email // (String Message = "Debe proporcionar un mail válido");
    private String mail;

    @NotNull //(String Message = "La contraseña no puede estar vacía");
    //@Size int min = 8, int max = 20; //, String message = "La contraseña debe tener entre 8 y 20 caracteres");
    //@Pattern (String regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{8,}$",
    // String message = "La contraseña debe incluir al menos una mayúscula, una minúscula, un número y un carácter especial");
    /*@Pattern(
            regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%&*+=._-]).{8,20}$",
            message = "La contraseña solo debe contener letras y números"
    )*/
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
