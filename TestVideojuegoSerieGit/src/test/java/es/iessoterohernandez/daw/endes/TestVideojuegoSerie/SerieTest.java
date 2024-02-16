package es.iessoterohernandez.daw.endes.TestVideojuegoSerie;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;


public class SerieTest {
	
	private Serie serie;
	

	@BeforeEach
	public void setUp() {
        serie = new Serie();
    }

	@AfterEach
	public void tearDown() {
        serie = null;
    }

	@Test
	public void testEntregar() {
		this.serie.entregar();
		assertTrue(this.serie.isEntregado());
	}

	@Test
	public void testDevolver() {
		serie.entregar();
		serie.devolver();
		assertFalse(serie.isEntregado());
	}

	@Test
	public void testIsEntregado() {
		assertFalse(serie.isEntregado());
		serie.entregar();
		assertTrue(serie.isEntregado());
	}

	@Test
	public void testCompareTo() {
		Serie serie1 = new Serie();
		serie1.setnumeroTemporadas(5);
		Serie serie2 = new Serie();
		serie2.setnumeroTemporadas(3);
		Serie serie3 = new Serie();
		serie3.setnumeroTemporadas(5);

		assertTrue(serie1.compareTo(serie2) > 0);
		assertTrue(serie1.compareTo(serie3) == 0);
		assertTrue(serie2.compareTo(serie1) < 0);
	}

	@Test
	public void testEquals() {
		Serie serie1 = new Serie();
		serie1.setTitulo("Evangelion");
		serie1.setcreador("Nobuo Uematsu");
		Serie serie2 = new Serie();
		serie2.setTitulo("Evangelion");
		serie2.setcreador("Nobuo Uematsu");
		Serie serie3 = new Serie();
		serie3.setTitulo("Zero");
		serie3.setcreador("Daus Hassel");

		assertTrue(serie1.equals(serie2));
		assertFalse(serie1.equals(serie3));
	}

}
