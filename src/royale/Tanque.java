package royale;

public class Tanque extends Personaje{
	public static final String NOMBRE_DEFAULT = "Tanque";
	public static final Integer DAÑO_DEFAULT = 10;
	public static final Integer SUERTE_DEFAULT = 2;
	public static final Integer ARMADURA_DEFAULT = 20;
	public static final Integer VIDA_DEFAULT = 120;
    private static final Integer USOS_DEFAULT = 2;
    
    public Tanque() throws ErrorEstadisticas{
    	super(VIDA_DEFAULT, DAÑO_DEFAULT, ARMADURA_DEFAULT, SUERTE_DEFAULT, NOMBRE_DEFAULT, USOS_DEFAULT);
    }
    
    @Override
    public boolean habilidadEspecial() {
    	boolean exito = false;
        if (super.usos != 0) {
            super.vida += 10;
            super.armadura += 10;
            super.usos--;
            exito = true;
        }
        
        return exito;
    }
}
