package es.iessoterohernandez.daw.endes.TestPersona;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class PersonaTest {

	private Persona persona;

	@BeforeEach
	public void init() {
		persona = new Persona();
	}

	@AfterEach
	public void finish() {
		persona = null;
	}

	@Test
	public void testCalcularIMC/* _pesoIdeal */() {
		persona = new Persona("Juan", 25, 'H', 70, 1.75);
		int pesoideal = persona.calcularIMC();
		assertEquals(Persona.PESO_IDEAL, pesoideal, "IMC retorna 0");

		persona = new Persona("Juan", 25, 'H', 45, 1.65);
		int infrapeso = persona.calcularIMC();
		assertEquals(Persona.INFRAPESO, infrapeso, "IMC retorna -1");

		persona = new Persona("Juan", 25, 'H', 90, 1.80);
		int sobrepeso = persona.calcularIMC();
		assertEquals(Persona.SOBREPESO, sobrepeso, "IMC retorna 1");
	}

	/*
	 * @Test public void testCalcularIMC_infrapeso() { persona = new Persona("Juan",
	 * 25, 'H', 45, 1.65); int infrapeso = persona.calcularIMC();
	 * assertEquals(Persona.INFRAPESO, infrapeso, "IMC retorna -1"); }
	 * 
	 * @Test public void testCalcularIMC_sobrepeso() { persona = new Persona("Juan",
	 * 25, 'H', 90, 1.80); int sobrepeso = persona.calcularIMC();
	 * assertEquals(Persona.SOBREPESO, sobrepeso, "IMC retorna 1"; }
	 */

	@Test
	public void testEsMayorDeEdad/* _mayorDeEdad */() {
		persona = new Persona("Juan", 25, 'H', 70, 1.75);
		boolean mayor = persona.esMayorDeEdad();
		assertTrue(mayor, "Mayor de Edad debe ser true");

		persona = new Persona("Juan", 17, 'H', 70, 1.75);
		boolean menor = persona.esMayorDeEdad();
		assertFalse(menor, "Mayor de Edad debe ser false");
	}

	/*
	 * @Test public void testEsMayorDeEdad_menorDeEdad() { persona = new
	 * Persona("Juan", 17, 'H', 70, 1.75); boolean resultado =
	 * persona.esMayorDeEdad(); assertFalse(menor, "Mayor de Edad debe ser false");
	 * }
	 */
	
	@Test
	public void testComprobarSexo() {
		persona = new Persona("Juan", 25, 'W', 70, 1.75);		 
		assertEquals(persona.getSexoDef(), persona.getSexo(), "Debe ser SEXO_DEF");
	}
	
	@Test
	public void testGenerarLetraDni() {
		persona = new Persona("Juan", 25, 'W', 70, 1.75);		 
		assertEquals(persona.generaLetraDNI(0), 'T', "Debe ser una de las letras permitidas");
	}
	
	/*@Test
	public void testGenerarDni() {
		persona = new Persona("Juan", 25, 'W', 70, 1.75);		 
		assertEquals(persona.getSexoDef(), persona.getSexo(), "Debe ser SEXO_DEF");
	}*/
	

}
