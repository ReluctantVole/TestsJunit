package es.iessoterohernandez.daw.endes.boletinJUnitBorja2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SubscripcionTest {

private Subscripcion s;
	
	@BeforeEach
	public void setUp() {
		s = new Subscripcion(3000, 12);
	}
	
	@AfterEach
	public void tearDown() {
		s = null;
	}
	
	@Test
	public void testPrecioPorMes() {
		assertEquals(250.0, s.precioPorMes(), 0.001);
	}
	
	@Test
	public void testPrecioPorMesPeriodoCero() {
		s = new Subscripcion(3000, 0);
		assertEquals(0.0, s.precioPorMes(), 0.001);
	}
	
	@Test
	public void testPrecioPorMesPrecioCero() {
		s = new Subscripcion(0, 12);
		assertEquals(0.0, s.precioPorMes(), 0.001);
	}
	
	@Test
	public void testCancel() {
		s.cancel();
		assertEquals(0, s.getPeriodo());
	}
	
	@Test
	public void testCancelPeriodoCero() {
		s = new Subscripcion(3000, 0);
		s.cancel();
		assertEquals(0, s.getPeriodo());
	}

}
