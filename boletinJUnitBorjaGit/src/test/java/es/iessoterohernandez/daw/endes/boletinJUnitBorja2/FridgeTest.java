package es.iessoterohernandez.daw.endes.boletinJUnitBorja2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class FridgeTest {

	private Fridge fridge;

    @BeforeEach
    public void setUp() {
        fridge = new Fridge();
    }

    @AfterEach
    public void tearDown() {
        fridge = null;
    }

    @Test
    public void testPut() {
        assertTrue(fridge.put("apple"));
        assertTrue(fridge.put("orange"));
        assertFalse(fridge.put("apple")); // no se pueden añadir dos veces el mismo elemento
    }
    
    @Test
    public void testContains() {
        assertFalse(fridge.contains("apple")); // la nevera está vacía
        fridge.put("apple");
        assertTrue(fridge.contains("apple")); // la nevera contiene una manzana
    }

    @Test
    public void testTake() throws NoSuchItemException {
        fridge.put("apple");
        fridge.put("orange");
        fridge.take("apple");
        assertFalse(fridge.contains("apple")); // ya no hay manzanas en la nevera
        assertTrue(fridge.contains("orange")); // sigue habiendo naranjas
        try {
            fridge.take("banana"); // intentamos sacar una fruta que no está en la nevera
            fail("Se esperaba NoSuchItemException");
        } catch (NoSuchItemException e) {
            assertEquals("banana not found in the fridge", e.getMessage()); // se lanza la excepción correcta
        }
    }

}
