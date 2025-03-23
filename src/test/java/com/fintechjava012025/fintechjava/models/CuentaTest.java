package com.fintechjava012025.fintechjava.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CuentaTest {

    //Metodo testDepositarMontoValido
    @Test
    void testDepositarMontoValido() {
        Cuenta cuenta = new Cuenta(1L, 100.0, "Ahorro"); //Crea una instancia de Cuenta con un saldo inicial de 100.0
        cuenta.depositar(50.0,"Deposito inicial"); //Llama al metodo depositar para agregar 50.0 a la cuenta

        //Verifica que el saldo sea 150.0 después del depósito usando assertEquals
        assertEquals(150.0, cuenta.getSaldo(), "El saldo deber ser 150.0 después del depósito");

        //Verifica que se haya registrado una transacción en la lista de transacciones de la cuenta
        assertEquals(1, cuenta.getTransacciones().size(), "Debe haber un transaccion que se ha depositado");
    }

    //Metodo testDepositarMontoInvalido
    @Test
    void testDepositarMontoInvalido() {
        Cuenta cuenta = new Cuenta(1L, 100.0, "Ahorro");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            cuenta.depositar(-50.0,"Deposito inválido");
        });
        assertEquals("El monto a depositar deber ser mayor a 0", exception.getMessage());
        assertEquals(100.0, cuenta.getSaldo(), "El saldo no debe cambiar si el depósito es inválido");
    }

    //Metodo testRetirarMontoValido
    @Test
    void testRetirarMontoValido() {
        Cuenta cuenta = new Cuenta(1L, 100.0, "Ahorro");
        cuenta.retirar(50.0,"Retiro inicial");

        assertEquals(50.0, cuenta.getSaldo(), "El saldo deber ser 50.0 después del retiro");
        assertEquals(1, cuenta.getTransacciones().size(), "Debe haber una transaccion registrada");
    }

    //Metodo testRetirarMontoInvlido
    @Test
    void testRetirarMontoInvalido() {
        Cuenta cuenta = new Cuenta(1L, 100.0, "Ahorro");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            cuenta.retirar(150.0,"Retiro excesivo");
        });
        assertEquals("Saldo insuficiente o monto inválido", exception.getMessage());
        assertEquals(100.0, cuenta.getSaldo(),"El saldo no debe cambiar si el retiro es inválido");
    }
}
