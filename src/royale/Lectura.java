package royale;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Lectura {

    // Clase estatica no se instancia
    private Lectura() {}

    public static List<String[]> leerJugadores(String ruta) {

        List<String[]> datos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {

            String linea;

            while ((linea = br.readLine()) != null) {

                String[] partes = linea.split(";");

                if (partes.length == 3) {
                    datos.add(partes); // [0]=Personaje, [1]=Herramienta, [2]=Jugador
                }
            }

        } catch (IOException e) {
            System.out.println("Error leyendo el fichero: " + e.getMessage());
        }

        return datos;
    }
}


