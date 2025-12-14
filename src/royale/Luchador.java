package royale;

public class Luchador extends Personaje{
	public static final String NOMBRE_DEFAULT = "Luchador";
	public static final Integer DAÑO_DEFAULT = 20;
	public static final Integer SUERTE_DEFAULT = 2;
	public static final Integer ARMADURA_DEFAULT = 10;
	public static final Integer VIDA_DEFAULT = 100;
    private static final Integer USOS_DEFAULT = 2;
    
    public Luchador() throws ErrorEstadisticas{
    	super(VIDA_DEFAULT, DAÑO_DEFAULT, ARMADURA_DEFAULT, SUERTE_DEFAULT, NOMBRE_DEFAULT, USOS_DEFAULT);
    }

    @Override
    public boolean habilidadEspecial() {
    	boolean exito = false;
        if (super.usos != 0) {
            super.vida += 10;
            super.daño += (int) super.vida / 5;
            super.usos--;
            exito = true;
        }
        
        return exito;
    }
}
