public class Elfo extends Personajes{
    //Atributos
    private final String nombre_Clase;
    public Elfo(){
        super(90,50,40);
        this.nombre_Clase="Elfo";
    }
    //Getter
    public String getNombre_Clase() {
        return nombre_Clase;
    }
    //toString
    @Override
    public String toString() {
        return super.toString() + "Elfo{" +
                    "nombre_Clase='" + nombre_Clase + '\'' +
                    '}';
        }
}
