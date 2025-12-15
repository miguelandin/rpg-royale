package royale;

public class Jugador implements Comparable<Jugador>{
	public Personaje personaje;
	public Herramienta herramienta;
	private String nombre;
	private Integer puntuacion;

	public static final Integer PUNTUACION_INICIAL = 0;
	public static Integer numeroJugador = 1;

	public Jugador(Personaje personaje, Herramienta herramienta) {
		this(personaje, herramienta, "CPU " + numeroJugador++);
	}

	public Jugador(Personaje personaje, Herramienta herramienta, String nombre) {
		this.personaje = personaje;
		this.herramienta = herramienta;
		this.nombre = nombre;
		this.puntuacion = PUNTUACION_INICIAL;
	}

	public void cambiarHerramienta(Herramienta herramienta) {
		this.herramienta = herramienta;
		System.out.println("cambiando de arma a: " + herramienta.toString());
	}
	
	public boolean estaVivo() {
		return this.personaje.vida > 0;
	}

	public Integer atacar(Jugador objetivo) {
		Integer dañoTotal = this.personaje.getDaño();
		if(!this.herramienta.comprobarModificacion()) { // si no está rota
			dañoTotal += this.herramienta.getDaño();
			this.herramienta.bajarDurabilidad(10);
			if(this.herramienta.esCritico()) { // si es ataque crítico
				dañoTotal *= this.personaje.getSuerte();
				System.out.println("CRÍTICO");
			}
		}
		
		double multiplicadorDaño = 100.0/(100.0+objetivo.personaje.getArmadura());
		Integer dañoReal = (int) (dañoTotal * multiplicadorDaño);
		objetivo.personaje.setVida(objetivo.personaje.getVida() - dañoReal);
		
		System.out.println("Daño infligido a " + objetivo.nombre + ": " + dañoReal);
		return dañoTotal;
	}

	public void curar() {
		System.out.println(this.nombre + " ha sido curado " +  this.personaje.curar() + " puntos de vida");
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void setPuntuacion(int puntuacion) {
		this.puntuacion += puntuacion;
		System.out.println("Puntuación: " + this.puntuacion);
	}

	@Override
	public String toString() {
        	return  this.nombre + ", puntuación: "+ this.puntuacion + ", " + this.personaje.toString() + ", " + this.herramienta.toString();
	}

	@Override
	public int compareTo(Jugador otroJugador) {
		return this.puntuacion.compareTo(otroJugador.puntuacion);
	}
}
