public class Caballero extends Personajes {
    //Atributos
    private final String nombre_Clase;
    public Caballero(){
        super(100,10,70);
        this.nombre_Clase="Caballero";
    }
    //Getter
    public String getNombre_Clase() {
        return nombre_Clase;
    }
    //toString
    @Override
    public String toString() {
        return super.toString() + "Caballero{" +
                "nombre_Clase='" + nombre_Clase + '\'' +
                '}';
    }
}
