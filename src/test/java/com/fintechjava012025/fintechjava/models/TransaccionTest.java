package com.fintechjava012025.fintechjava.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;

public class TransaccionTest {

    @Test
    void testCrearTransaccionValido() {
        Cuenta cuenta = new Cuenta(1L, 100.0, "Ahorro");
        Transaccion transaccion = new Transaccion(1L,50.0, LocalDateTime.now(),"Depósito", "Depósito inicial", cuenta);

        //Verificaciones
        assertNotNull (transaccion); // ¿Se creó el objeto?
        assertEquals(1L, transaccion.getId()); // ¿ID correcto?
        assertEquals(50.0, transaccion.getMonto()); // ¿Monto correcto?
        assertEquals("Depósito", transaccion.getTipo()); // ¿Tipo correcto?
        assertEquals("Depósito inicial", transaccion.getMotivo());
        assertEquals(cuenta, transaccion.getCuenta()); // ¿Cuenta asociada correcta?
    }

    @Test
    void testCrearTransaccionInvalido() {
        Cuenta cuenta = new Cuenta(1L, 100.0, "Ahorro");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
           new Transaccion(1L,-50.0, LocalDateTime.now(),"Depósito", "Depósito inicial", cuenta);
        });
        assertEquals("El monto no puede ser nulo", exception.getMessage());
    }

}
