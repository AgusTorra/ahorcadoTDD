import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AhorcadoTest {
	
	@Test
	public void jugadorAnonimoTest() {
		
		//arrange
		
		Ahorcado ahorcado=new Ahorcado();
		
		
		//Act
		ahorcado.ingresarNombre("Juan");
		
		//Assert
		
		assertEquals("Juan", ahorcado.getNombre());
		
	}
	
	@Test
	
	public void IngresarPalabraTest() {
		
		//arrange
		
		Ahorcado ahorcado=new Ahorcado();

		//act
		
		ahorcado.ingresarPalabra("ahorcado");
		//assert
		
		assertEquals("ahorcado", ahorcado.getPalabra());
	}
	
	@Test	
	public void ingresarLetraIncorrectaTest() {
		
		//arrange
		
		Ahorcado ahorcado=new Ahorcado();
		ahorcado.ingresarPalabra("ahorcado");
		
		//act
		
		boolean resultado=ahorcado.ingresarLetra("y");
		
		//assert
		
		assertEquals(false, resultado);
		
	}
	
	@Test	
	public void ingresarLetraCorrectaTest() {
		
		//arrange
		
		Ahorcado ahorcado=new Ahorcado();
		ahorcado.ingresarPalabra("ahorcado");
		
		//act
		
		boolean resultado=ahorcado.ingresarLetra("h");
				
		//assert
				
		assertEquals(true, resultado);
	}
	
	

}
