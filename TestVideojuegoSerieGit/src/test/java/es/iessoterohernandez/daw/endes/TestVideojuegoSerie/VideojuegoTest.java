package es.iessoterohernandez.daw.endes.TestVideojuegoSerie;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

class VideojuegoTest {

	private Videojuego videojuego;

    @Before
    public void setUp() {
        videojuego = new Videojuego();
    }

    @After
    public void tearDown() {
        videojuego = null;
    }
    
    @Test
    public void testEntregar() {
        videojuego.entregar();
        assertTrue(videojuego.isEntregado());
    }

    @Test
    public void testDevolver() {
        videojuego.entregar();
        videojuego.devolver();
        assertFalse(videojuego.isEntregado());
    }

    @Test
    public void testIsEntregado() {
        assertFalse(videojuego.isEntregado());
        videojuego.entregar();
        assertTrue(videojuego.isEntregado());
    }
    
    @Test
    public void testCompareTo() {
        Videojuego videojuego1 = new Videojuego();
        videojuego1.setHorasEstimadas(30);
        Videojuego videojuego2 = new Videojuego();
        videojuego2.setHorasEstimadas(20);
        Videojuego videojuego3 = new Videojuego();
        videojuego3.setHorasEstimadas(30);
        
        assertTrue(videojuego1.compareTo(videojuego2) > 0);
        assertTrue(videojuego1.compareTo(videojuego3) == 0);
        assertTrue(videojuego2.compareTo(videojuego1) < 0);
    }

    @Test
    public void testEquals() {
        Videojuego videojuego1 = new Videojuego();
        videojuego1.setTitulo("Smash");
        videojuego1.setcompañia("Nintendo");
        Videojuego videojuego2 = new Videojuego();
        videojuego2.setTitulo("Smash");
        videojuego2.setcompañia("Nintendo");
        Videojuego videojuego3 = new Videojuego();
        videojuego3.setTitulo("Kingdom Hearts");
        videojuego3.setcompañia("Squaresoft");
        
        assertTrue(videojuego1.equals(videojuego2));
        assertFalse(videojuego1.equals(videojuego3));
    }


}
