
public class Ahorcado {
	
	private String nombre;
	private String palabra;
	private String letra;

	public String getNombre() {
		return nombre;
	}
	
	public String ingresarNombre(String nombre) {
		
		this.nombre=nombre;
		
		return nombre;
	}
	
	public String ingresarPalabra(String palabra) {
		
		this.palabra=palabra;
		
		return palabra;
	}
	
	public String getPalabra() {
		return palabra;
	}
	
	public boolean ingresarLetra(String letra) {
		
		return palabra.contains(letra);
	}
	
	
	

}
