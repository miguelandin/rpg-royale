package royale;
import java.util.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class GameLoop {
    List<Jugador> jugadores;
    List<Jugador> ia;
    List<Jugador> combatientes;
   
    Volcado dump = new Volcado();
	public static final String RUTA_OUT = "public/logs.txt";
	public static final int INCREMENTO_USOS = 1;
    
    private static Scanner scanner = new Scanner(System.in);
    
    private static final String TITULO = "____________________  ________         __________                     .__          \n"
            + "\\______   \\______   \\/  _____/         \\______   \\ ____ ___.__._____  |  |   ____  \n"
            + " |       _/|     ___/   \\  ___   ______ |       _//  _ <   |  |\\__  \\ |  | _/ __ \\ \n"
            + " |    |   \\|    |   \\    \\_\\  \\ /_____/ |    |   (  <_> )___  | / __ \\|  |_\\  ___/ \n"
            + " |____|_  /|____|    \\______  /         |____|_  /\\____// ____|(____  /____/\\___  >\n"
            + "        \\/                  \\/                 \\/       \\/          \\/          \\/ ";
    
    public GameLoop() throws ErrorEstadisticas {
        this.jugadores = new ArrayList<>();
        this.combatientes = new ArrayList<>();

        System.out.println(TITULO);
        
        int input;
        
        while(true) {
            System.out.println("\nSeleccione Acción: \n(1) Nuevo Jugador \n(2) Siguiente"); 
            input = scanner.nextInt();
            
            if(input == 2) {
                break;
            } else if (input == 1) {
                jugadores.add(crearJugador());
            } else {
                System.out.println("Opción no válida");
            }
        }
        
        this.ia = crearListaIA();
        
        this.combatientes.addAll(this.jugadores);
        this.combatientes.addAll(this.ia);
    }
    
    public GameLoop(String ruta) throws ErrorEstadisticas{
        this.jugadores = new ArrayList<>();
        this.combatientes = new ArrayList<>();

    	List<String[]> datosArchivo = Lectura.leerJugadores(ruta);
        
        for (String[] fila : datosArchivo) {
            String textoClase = fila[0];
            String textoArma = fila[1];
            String nombreJugador = fila[2];
            
            Personaje personaje;
            if (textoClase.equals("Tanque")) personaje = new Tanque();
            else if (textoClase.equals("Asesino")) personaje = new Asesino();
            else personaje = new Luchador();
            
            Herramienta herramienta;
            if (textoArma.equals("Espada")) herramienta = new Espada();
            else if (textoArma.equals("Daga")) herramienta = new Daga();
            else herramienta = new Mandoble();
            
            Jugador nuevoJugador = new Jugador(personaje, herramienta, nombreJugador);
            this.jugadores.add(nuevoJugador);
        }
        
        this.ia = crearListaIA();
        
        this.combatientes.addAll(this.jugadores);
        this.combatientes.addAll(this.ia);
    }

    private Jugador crearJugador() throws ErrorEstadisticas{
        System.out.println("\n--- Creando Personaje ---");
        System.out.println("Seleccione Clase: \n(1) Luchador \n(2) Asesino \n(3) Tanque");
        int input = scanner.nextInt();
        
        Personaje personaje;
        if(input == 1) personaje = new Luchador();
        else if(input == 2) personaje = new Asesino();
        else personaje = new Tanque();
        
        System.out.println("Selecciona Arma: \n(1) Espada \n(2) Daga \n(3) Mandoble");
        input = scanner.nextInt();
        
        Herramienta herramienta;
        if(input == 1) herramienta = new Espada();
        else if(input == 2) herramienta = new Daga();
        else herramienta = new Mandoble();
        
        scanner.nextLine(); 
        
        System.out.print("Nombre del Jugador: ");
        String nombre = scanner.nextLine();
        
        Jugador jugador;
        jugador = new Jugador(personaje, herramienta, nombre);
        
        System.out.print("Jugador Creado: " + jugador.toString());
        return jugador;
    }
    
    private Jugador crearJugadorAleatorio() throws ErrorEstadisticas{
    	Personaje personaje;
    	Herramienta herramienta;
    	Random random = new Random();
    	int dado = random.nextInt(3);
    	
    	if(dado == 0)
    		personaje = new Luchador();
    	else if(dado == 1)
    		personaje = new Asesino();
    	else
    		personaje = new Tanque();
    	
    	dado = random.nextInt(3);
    	
    	if(dado == 0)
    		herramienta = new Espada();
    	else if(dado == 1)
    		herramienta = new Daga();
    	else
    		herramienta = new Mandoble();
    	
    	Jugador jugador = new Jugador(personaje, herramienta);
    	
    	return jugador;
    }
    
    private List<Jugador> crearListaIA() throws ErrorEstadisticas{
    	List<Jugador> ia = new ArrayList<>();
    	
        System.out.println("Seleccione el número de CPUs: ");
        int input = scanner.nextInt();
        scanner.nextLine();
        
        for(int i = 0; i < input; i++)
        	ia.add(crearJugadorAleatorio());
        
        return ia;
    }
    
    public void jugar() throws IOException {
    	int ronda = 1;    	
    	while(true) {
    		String rondaS = "Ronda " + ronda++;
    		System.out.println(rondaS);
    		dump.agregarLinea(rondaS);
    		dump.agregarLinea(this.toString());
    		scanner.nextLine();
    		
    		if(this.combatientes.size() <= 1)
    			break;
    		
    		for(int i = 0; i < this.jugadores.size(); i++) {
        		if(this.combatientes.size() <= 1)
        			break;
    			hacerAccion(jugadores.get(i));
    		}
    		
    		for(int i = 0; i < this.ia.size(); i++) {
        		if(this.combatientes.size() <= 1)
        			break;
    			hacerAccionAutomatica(ia.get(i));
    		}
    	}
    	
    	limpiarPantalla();
    	String resultado = "FIN DE LA PARTIDA\nGanador: " + this.combatientes.get(0).toString();
    	dump.agregarLinea(resultado);
    	System.out.println(resultado);
    	dump.volcarAFichero(RUTA_OUT);
    }
    
    private void limpiarPantalla() {
        System.out.println("\n".repeat(50)); 
    }
    
    private void hacerAccion(Jugador jugadorActual) {
        boolean turnoTerminado = false;
        
        while (!turnoTerminado) {
            limpiarPantalla();
            System.out.println("Turno de: " + jugadorActual.getNombre());
            System.out.println(jugadorActual.toString());
            System.out.println("-------------------------");
            System.out.println("(1) Acción\n(2) Examinar");
            int input = scanner.nextInt();
            
            if (input == 2) {
                verSala();
                System.out.println("Pulsa Enter para volver...");
                scanner.nextLine(); scanner.nextLine();
                continue;
            }

            if (input == 1) {
                System.out.println("\nSelecciona Acción:");
                System.out.println("(1) Atacar \n(2) Curar \n(3) Reparar Arma \n(4) Habilidad Especial \n(5) Volver");
                int accion = scanner.nextInt();

                switch (accion) {
                    case 1: atacar(jugadorActual); turnoTerminado = true; break;
                    case 2: curar(jugadorActual); turnoTerminado = true; break;
                    case 3: reparar(jugadorActual); turnoTerminado = true; break;
                    case 4: especial(jugadorActual); turnoTerminado = true; break;
                    case 5: break;
                   
                    default: System.out.println("Opción no válida");
                }
        		scanner.nextLine();
        		scanner.nextLine();
            }
        }
    }
    
    private void verSala() {
			for(int i = 0; i < this.combatientes.size(); i++)
				System.out.println("("+i+") " + this.combatientes.get(i).toString());
    }
    
    @Override
    public String toString() {
    	    StringBuilder sb = new StringBuilder();

    	    for(int i = 0; i < this.combatientes.size(); i++) {
    	        sb.append("(").append(i).append(") ");
    	        sb.append(this.combatientes.get(i).toString());
    	        sb.append("\n");
    	    }
    	    return sb.toString();
    }
    
    private void atacar(Jugador jugadorActual) {
    	int input;
		limpiarPantalla();
		System.out.println("Atacar: ");
		
		verSala();
		input = scanner.nextInt();
		
		if(input < 0 || input >= this.combatientes.size())
			input = 0;
		
		Jugador objetivo = this.combatientes.get(input);
		
		jugadorActual.atacar(objetivo);
		
		if(!objetivo.estaVivo()) {
			System.out.println(objetivo.getNombre() + " eliminado\n(1) Coger Arma\n(2) Celebrar");
			int input1 = scanner.nextInt();
			if(input1 == 1) {
				jugadorActual.cambiarHerramienta(objetivo.herramienta);
			}else
				System.out.println("gg");
			
			this.combatientes.remove(input);
			jugadorActual.setPuntuacion(100);
			jugadorActual.personaje.setUsos(INCREMENTO_USOS);
		}
    }
    
    private void curar(Jugador jugadorActual) {
    	int input;
    	limpiarPantalla();
    	System.out.println("Curar: ");
    	
    	verSala();
		input = scanner.nextInt();
		
		if(input < 0 || input >= this.combatientes.size())
			jugadorActual.curar();
		else
			this.combatientes.get(input).curar();
    }
    
    private void reparar(Jugador jugadorActual) {
    	if(jugadorActual.herramienta.modifica())
    		System.out.println("Arma Mejorada: " + jugadorActual.herramienta.toString());
    	else {
    		System.out.println("La arma aún no está rota: " + jugadorActual.herramienta.toString());
    		scanner.nextLine();
    		hacerAccion(jugadorActual);
    	}
    }
    
    private void especial(Jugador jugadorActual) {
    	jugadorActual.personaje.habilidadEspecial();
    	System.out.println(jugadorActual.getNombre() + " aumenta sus estadísticas: " + jugadorActual.personaje.toString());
    }
    
    private void hacerAccionAutomatica(Jugador cpuActual) {
    	System.out.println(cpuActual.getNombre());
    	if(cpuActual.personaje.vida <= 30)
    		cpuActual.curar();
    	else if(cpuActual.herramienta.comprobarModificacion())
    		reparar(cpuActual);
    	else if(cpuActual.personaje.getUsos() > 0)
    		especial(cpuActual);
    	else {
        	atacarAutomatico(cpuActual);
    	}
    	
		scanner.nextLine();
    }
    
    private void atacarAutomatico(Jugador cpuActual) {
        	Random random = new Random();
        	Jugador objetivo;
        	int dado;
        	
        	do { // asegurarse de que no se ataque a uno mismo
            	dado = random.nextInt(this.combatientes.size());
            	objetivo = this.combatientes.get(dado);
        	}while(objetivo == cpuActual);
        		
        	cpuActual.atacar(objetivo);
        	
        	if(!objetivo.estaVivo()) {
        		System.out.println(objetivo.getNombre()+ " ha sido eliminado");
        		if(cpuActual.herramienta.compareTo(objetivo.herramienta) == -1)
        			cpuActual.cambiarHerramienta(objetivo.herramienta);
        		this.combatientes.remove(dado);
        		cpuActual.setPuntuacion(100);
        		cpuActual.personaje.setUsos(INCREMENTO_USOS);
        	}
    }
}