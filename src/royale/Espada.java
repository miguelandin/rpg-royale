package royale;

public class Espada extends Herramienta {
	public static final String NOMBRE_DEFAULT = "Espada";
	public static final Integer DAÑO_DEFAULT = 30;
	public static final Integer CRITICO_DEFAULT = 20;
	public static final Integer DURABILIDAD_DEFAULT = 30;
	
	public Espada() {
		super(NOMBRE_DEFAULT, DAÑO_DEFAULT, CRITICO_DEFAULT, DURABILIDAD_DEFAULT);
	}
}
