package royale;

public class Jugador implements Comparable<Jugador>{
	private Personaje personaje;
	private Herramienta herramienta;
	private String nombre;
	private Integer puntuacion;

	public static final Integer PUNTUACION_INICIAL = 0;
	public static Integer numeroJugador = 1;

	public Jugador(Personaje personaje, Herramienta herramienta) {
		this(personaje, herramienta, "Jugador + " + numeroJugador++);
	}

	public Jugador(Personaje personaje, Herramienta herramienta, String nombre) {
		this.personaje = personaje;
		this.herramienta = herramienta;
		this.nombre = nombre;
		this.puntuacion = PUNTUACION_INICIAL;
	}

	public void cambiarHerramienta(Herramienta herramienta) {
		this.herramienta = herramienta;
	}

	public Integer atacar(Personaje objetivo) {
		Integer dañoTotal = this.personaje.getDaño();
		if(!this.herramienta.comprobarModificacion()) { // si no está rota
			dañoTotal += this.herramienta.getDaño();
			this.herramienta.bajarDurabilidad(10);
			if(this.herramienta.esCritico()) // si es ataque crítico
				dañoTotal *= this.personaje.getSuerte();
		}
		
		objetivo.setVida(objetivo.getVida() - dañoTotal);
		
		return dañoTotal;
	}

	public Integer curar() {
		return this.personaje.curar();
	}

	@Override
	public String toString() {
        	return "Player [nombre= " + this.nombre + ", personaje= " + this.personaje.toString() + ", herramienta= " + this.herramienta.toString() + ", puntuacion= " + this.puntuacion + "]";
	}

	@Override
	public int compareTo(Jugador otroJugador) {
		return this.puntuacion.compareTo(otroJugador.puntuacion);
	}
}
