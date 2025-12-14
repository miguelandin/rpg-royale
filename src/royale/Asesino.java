package royale;

public class Asesino extends Personaje{
	public static final String NOMBRE_DEFAULT = "Asesino";
	public static final Integer DAÑO_DEFAULT = 30;
	public static final Integer SUERTE_DEFAULT = 2;
	public static final Integer ARMADURA_DEFAULT = 0;
	public static final Integer VIDA_DEFAULT = 80;
    private static final Integer USOS_DEFAULT = 2;

    
    public Asesino() throws ErrorEstadisticas{
    	super(VIDA_DEFAULT, DAÑO_DEFAULT, ARMADURA_DEFAULT, SUERTE_DEFAULT, NOMBRE_DEFAULT, USOS_DEFAULT);
    }

    @Override
    public boolean habilidadEspecial() {
    	boolean exito = false;
        if (super.usos != 0) {
            super.daño += 10;
            super.suerte += 1;
            super.usos--;
            exito = true;
        }
        
        return exito;
    }

}