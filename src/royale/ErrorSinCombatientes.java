package royale;

public class ErrorSinCombatientes extends RuntimeException {
    public ErrorSinCombatientes() {
        super("No se puede iniciar el juego. La lista de combatientes está vacía.");
    }
}