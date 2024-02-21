package es.iessoterohernandez.daw.endes.boletinJUnitBorja2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PilaTest {

	private Pila pila;

	@BeforeEach
	public void setUp() throws Exception {
		pila = new Pila();
	}

	@AfterEach
	public void tearDown() throws Exception {
		pila = null;
	}

	@Test
	public void testPush() {
		pila.push(3);
		assertEquals(3, pila.pop());
	}

	@Test
	public void testPop() {
		assertNull(pila.pop());
		pila.push(3);
		assertEquals(3, pila.pop());
		assertNull(pila.pop());
	}

	@Test
	public void testIsEmpty() {
		assertTrue(pila.isEmpty());
	}

	@Test
	public void testTop() {
		assertNull(pila.top());
		pila.push(3);
		assertEquals(3, pila.top());
		assertEquals(3, pila.pop());
		assertNull(pila.top());
	}

	@Test
	public void testPushOutOfRange() {
		pila.push(1);
		pila.push(21);
		assertTrue(pila.isEmpty());
	}
}
