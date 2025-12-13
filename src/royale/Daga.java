package royale;

public class Daga extends Herramienta {
	public static final String NOMBRE_DEFAULT = "Daga";
	public static final Integer DAÑO_DEFAULT = 10;
	public static final Integer CRITICO_DEFAULT = 40;
	public static final Integer DURABILIDAD_DEFAULT = 20;
	
	public Daga() {
		super(NOMBRE_DEFAULT, DAÑO_DEFAULT, CRITICO_DEFAULT, DURABILIDAD_DEFAULT);
	}
}
