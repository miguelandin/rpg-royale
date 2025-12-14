package royale;

public class ErrorEstadisticas extends Exception {
    private static final String MENSAJE_DEFECTO = "La suma de las estadísticas no puede ser mayor a 180";

    public ErrorEstadisticas() {
        super(MENSAJE_DEFECTO);
    }

}