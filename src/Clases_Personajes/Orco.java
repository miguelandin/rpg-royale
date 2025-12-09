public class Orco extends Personajes{
    //Atributos
    private final String nombre_Clase;
    public Orco(){
        super(100,30,50);
        this.nombre_Clase="Orco";
    }
    //Getter
    public String getNombre_Clase() {
        return nombre_Clase;
    }
    //toString
    @Override
    public String toString() {
        return super.toString() + "Orco{" +
                "nombre_Clase='" + nombre_Clase + '\'' +
                '}';
    }
}
