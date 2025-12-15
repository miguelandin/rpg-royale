package royale;

import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) throws ErrorEstadisticas, IOException {
		GameLoop gameLoop;
		Scanner scanner = new Scanner(System.in);
		
		while(true){
			System.out.println("Seccione opción:\n(1) Cargar Partida\n(2) Nueva Partida\n(3) Salir");
			int input = scanner.nextInt();
			scanner.nextLine();
			
			if(input == 1) {
				System.out.print("Ruta al fichero: ");
				String inputS = scanner.nextLine();
				gameLoop = new GameLoop(inputS);				
			}
			else if(input == 2)
				gameLoop = new GameLoop();
			else
				break;
			
			gameLoop.jugar();
		}
		
		scanner.close();
	}
}