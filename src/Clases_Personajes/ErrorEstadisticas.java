public class ErrorEstadisticas extends RuntimeException {
    private static final String message = "La suma de las estadisticas no puede ser mayor a 180";
    public ErrorEstadisticas(String message) {
        super(message);
    }
}
