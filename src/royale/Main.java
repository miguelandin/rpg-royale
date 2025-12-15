package royale;

import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) throws ErrorEstadisticas, IOException {
		final String RUTA_IN = "public/jugadores.txt";
		GameLoop gameLoop;
		Scanner scanner = new Scanner(System.in);
		int input;
		
		while(true){
			System.out.println("Seccione opción:\n(1) Cargar Partida\n(2) Nueva Partida\n(3) Salir");
			input = scanner.nextInt();
			
			if(input == 1)
				gameLoop = new GameLoop(RUTA_IN);
			else if(input == 2)
				gameLoop = new GameLoop();
			else
				break;
			
			gameLoop.jugar();
		}
	}
}