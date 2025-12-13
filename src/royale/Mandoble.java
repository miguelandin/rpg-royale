package royale;

public class Mandoble extends Herramienta{
	public static final String NOMBRE_DEFAULT = "Mandoble";
	public static final Integer DAÑO_DEFAULT = 40;
	public static final Integer CRITICO_DEFAULT = 10;
	public static final Integer DURABILIDAD_DEFAULT = 40;
	
	public Mandoble() {
		super(NOMBRE_DEFAULT, DAÑO_DEFAULT, CRITICO_DEFAULT, DURABILIDAD_DEFAULT);
	}
}