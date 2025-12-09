public class Mago extends Personajes{
    //Atributos
    private final String nombre_Clase;

    public Mago(){
        super(80,80,20);
        this.nombre_Clase="Caballero";
    }
    //Getter
    public String getNombre_Clase() {
        return nombre_Clase;
    }
    //toString
    @Override
    public String toString() {
        return super.toString()+"Caballero{" +
                "nombre_Clase='" + nombre_Clase + '\'' +
                '}';
    }
}
