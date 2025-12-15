package royale;
import java.util.Random;

public abstract class Herramienta implements Comparable<Herramienta>, Modificable{
	protected String nombre;
	protected Integer daño;
	protected Integer critico;
	protected Integer durabilidad;
	
	protected Herramienta(String nombre, Integer daño, Integer critico, Integer durabilidad) {
		this.nombre = nombre;
	    this.daño = daño;
	    this.critico = critico;
	    this.durabilidad = durabilidad;
	}
	
	public boolean comprobarModificacion() {
		return (this.durabilidad <= 0);
	}
	    
	public boolean modifica() {
		boolean exito = false;
		if (comprobarModificacion()) {
			this.daño += 10;
			this.durabilidad = 50;
			exito = true;
	    }
		
		return exito;
	}
	
	public boolean esCritico() {
		Random dado = new Random();
		
		Integer numero = dado.nextInt(100);
		
		return numero < this.critico;
	}
	 
	void bajarDurabilidad(Integer cantidad) {
		this.durabilidad -= cantidad;
	}
	
	public String getNombre() {
		return nombre;
	}

	public Integer getDaño() {
		 return daño;
	}

	public Integer getCritico() {
		 return critico;
	}

	public Integer getDurabilidad() {
		 return durabilidad;
	}
	
	@Override
	public String toString() {
		return nombre + "{daño=" + daño + ", crítico=" + critico + "%, durabilidad=" + durabilidad + "}";
	}

	@Override
	public int compareTo(Herramienta otraHerramienta) {
	    return this.daño.compareTo(otraHerramienta.getDaño());
	}
}