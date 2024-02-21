package es.iessoterohernandez.daw.endes.boletinJUnitBorja2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;


class OperadorAritmeticoTest {

	//Se debe crear un objeto OperadorAritmetico e inicializarlo en los before y after each para dar coverage a la clase OperadorAritmetico
	private OperadorAritmetico operadorAritmetico;
	
	@BeforeEach
    public void beforeEach() {
        System.out.println("Antes de cada test");
        operadorAritmetico = new OperadorAritmetico();
    }

    @AfterEach
    public void afterEach() {
        System.out.println("Después de cada test");
        operadorAritmetico = null ;
    }

    @Test
    public void testSuma() {
        assertEquals(5, OperadorAritmetico.suma(2, 3));
        assertEquals(10, OperadorAritmetico.suma(7, 3));
        assertEquals(0, OperadorAritmetico.suma(0, 0));
    }

    @Test
    public void testDivision() {

        try {
            assertEquals(2, OperadorAritmetico.division(4, 2));
            assertEquals(3, OperadorAritmetico.division(9, 3));
            assertEquals(0, OperadorAritmetico.division(0, 5));
            OperadorAritmetico.division(4, 0);
            fail("Se esperaba una excepción");
        } catch (Exception e) {
            // Se espera una excepción
        }
    }

}
