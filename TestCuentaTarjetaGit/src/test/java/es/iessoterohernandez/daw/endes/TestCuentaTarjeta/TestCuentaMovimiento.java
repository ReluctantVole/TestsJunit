package es.iessoterohernandez.daw.endes.TestCuentaTarjeta;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestCuentaMovimiento {

	Cuenta cuenta;
	
	@BeforeEach
	void init() {
		cuenta = new Cuenta("000111222", "Sirius");
	}
	
	@AfterEach
	void finish() {
		cuenta = null;
	}
	
	@ParameterizedTest(name = "Ingresar {0}€")
	@MethodSource("cantidades")
	void testIngresarDinero(double cantidad) {
		try {
			cuenta.ingresar(cantidad);
			assertThat(cuenta.mMovimientos.size(), is(1));
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	@ParameterizedTest(name = "Retirar {0}€")
	@MethodSource("cantidades")
	void testRetirarDinero(double cantidad) {
		try {
			cuenta.ingresar(80D);
			assertThat(cuenta.mMovimientos.size(), is(1));
			cuenta.retirar(cantidad);
			assertThat(cuenta.mMovimientos.size(), is(2));
			assertEquals(((Movimiento) cuenta.mMovimientos.get(1)).getImporte(), -cantidad);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	@ParameterizedTest(name = "Ingresar {0}€ en una fecha")
	@MethodSource("cantidades")
	void testIngresarDineroConFecha(double cantidad) {
		try {
			cuenta.ingresar(cantidad);
			Movimiento mov = (Movimiento) cuenta.mMovimientos.get(0);
			mov.setFecha(new Date(2024, 1, 1));
			assertThat(mov.getConcepto(), is("Ingreso en efectivo"));
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	@ParameterizedTest(name = "Retirar {0}€ en una fecha")
	@MethodSource("cantidades")
	void testRetirarDineroConFecha(double cantidad) {
		try {
			cuenta.ingresar(80D);
			assertThat(cuenta.mMovimientos.size(), is(1));
			((Movimiento) cuenta.mMovimientos.get(0)).setFecha(new Date(2024, 1, 2));
			cuenta.retirar(cantidad);
			assertThat(cuenta.mMovimientos.size(), is(2));
			((Movimiento) cuenta.mMovimientos.get(1)).setFecha(new Date(2024, 1, 3));
			assertEquals(((Movimiento) cuenta.mMovimientos.get(1)).getImporte(), -cantidad);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	@ParameterizedTest(name = "{0} con {1}€")
	@MethodSource("ingresosConceptos")
	void testIngresarDineroConConcepto(String concepto, double cantidad) {
		try {
			cuenta.ingresar(concepto, cantidad);
			assertThat(cuenta.mMovimientos.size(), is(1));
		} catch (Exception ex) {
			System.out.println(concepto + ": " + ex.getMessage());
		}
	}
	
	@ParameterizedTest(name = "{0} con {1}€")
	@MethodSource("retiradasConceptos")
	void testRetirarDineroConConcepto(String concepto, double cantidad) {
		try {
			cuenta.ingresar(80D);
			assertThat(cuenta.mMovimientos.size(), is(1));
			cuenta.retirar(concepto, cantidad);
			assertThat(cuenta.mMovimientos.size(), is(2));
			assertEquals(((Movimiento) cuenta.mMovimientos.get(1)).getConcepto(), concepto);
		} catch (Exception ex) {
			System.out.println(concepto + ": " + ex.getMessage());
		}
	}
	
	@Test
	void testSaldoTotal() {
        for (Double cantidad : cantidades().toArray(Double[]::new)) {
            try {
                cuenta.ingresar(cantidad);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
		double saldo = cantidades()
	                   .filter(cantidad -> cantidad > 0)
	                   .mapToDouble(Double::doubleValue)
	                   .sum();
        assertThat(cuenta.getSaldo(), is(saldo));
	}
	
	static Stream<Double> cantidades() {
		return Stream.of(0D, 50D, 100D, -100D);
	}
	
	static Stream<Arguments> ingresosConceptos() {
        return Stream.of(
    		Arguments.of("Ingreso A", 0D),
    		Arguments.of("Ingreso B", 50D),
    		Arguments.of("Ingreso C", 100D),
    		Arguments.of("Ingreso D", -100D)
    	);
    }
	
	static Stream<Arguments> retiradasConceptos() {
        return Stream.of(
    		Arguments.of("Retirada A", 0D),
    		Arguments.of("Ingreso B", 50D),
    		Arguments.of("Ingreso C", 100D),
    		Arguments.of("Retirada D", -100D)
    	);
    }

}