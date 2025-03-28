package com.fintechjava012025.fintechjava.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClienteTest {

    @Test
    void testCrearClienteValido() {
        Cliente cliente = new Cliente(30985354L, "Marcelo", "Guerra", "marcelo.guerra@gmail.com", "Password01");

        //Verificaciones
        assertNotNull(cliente); //Verifica que el objeto cliente no sea null
        assertEquals(30985354L,cliente.getDNI()); //Compara que el DNI del cliente sea igual a 12345678L
        assertEquals("Marcelo",cliente.getNombre()); //Verifica que el nombre del cliente sea "Marcelo"
        assertEquals("Guerra",cliente.getApellido()); //Confirma que el apellido del cliente sea "Guerra"
        assertEquals("marcelo.guerra@gmail.com",cliente.getMail()); //Valida que el email del cliente coincida con "marcelo.guerra@gmail.com". Verifica el formato exacto del correo (incluyendo puntos, @, etc.).
        assertEquals("Password01",cliente.getContrasenia()); //Comprueba que la contraseña del cliente sea "Password01!"
    }

    @Test
    void testCrearClienteInvalido() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Cliente(null, "Marcelo", "Guerra", "marcelo.guerra@gmail.com", "Password01");
        });
        assertEquals("El DNI no puede ser nulo", exception.getMessage());
    }
}
