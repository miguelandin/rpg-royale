package royale;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException; //Importo la excepciOn de Entrada/Salida
import java.util.ArrayList; //Importo la lista dinámica

public class Volcado {
    private ArrayList<String> listaDeLaPartida;

    public Volcado() {
        this.listaDeLaPartida = new ArrayList<String>();
    }

    public void agregarLinea(String linea) {
        this.listaDeLaPartida.add(linea);
    }

    public void volcarAFichero(String nombreFichero) throws IOException {
        FileWriter fw = new FileWriter(nombreFichero, true);
        BufferedWriter writer = new BufferedWriter(fw);

        for (String frase : this.listaDeLaPartida) {
            writer.write(frase);
            writer.newLine();
        }

        writer.close();

        this.listaDeLaPartida.clear();
    }
}