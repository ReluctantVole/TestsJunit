package es.iessoterohernandez.daw.endes.TestCarritoCompra;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class ShoppingCartTest {

private ShoppingCart cart;
	
	@BeforeEach
	public void setUp() throws Exception {
		cart = new ShoppingCart();
	}

	@AfterEach
	public void tearDown() throws Exception {
		cart = null;
	}

	@Test
	public void testCartInitiallyEmpty() {
		assertEquals(0, cart.getItemCount());
	}
	
	@Test
	public void testEmptyCartHasZeroBalance() {
		assertEquals(0.00, cart.getBalance(), 0.001);
	}
	
	@Test
	public void testAddingItemIncrementsItemCount() {
		Product item = new Product("Test Product", 10.00);
		cart.addItem(item);
		assertEquals(1, cart.getItemCount());
	}
	
	@Test
	public void testAddingItemUpdatesBalance() {
		Product item = new Product("Test Product", 10.00);
		cart.addItem(item);
		assertEquals(10.00, cart.getBalance(), 0.001);
	}
	
	@Test
	public void testRemovingItemDecrementsItemCount() throws ProductNotFoundException {
		Product item = new Product("Test Product", 10.00);
		cart.addItem(item);
		cart.removeItem(item);
		assertEquals(0, cart.getItemCount());
	}
	
	@Test
	public void testRemovingNonexistentItemThrowsException() {
		Product item = new Product("Test Product", 10.00);
		try {
			cart.removeItem(item);
			fail("ProductNotFoundException not thrown");
		} catch  (ProductNotFoundException exception) {}
	}

}
