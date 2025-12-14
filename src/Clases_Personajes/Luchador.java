public class Luchador extends Personajes{
    //Atributos
    private String Nombre="Luchador";
    private int UsosHabilidades=2;
    //Constructor
    Luchador(){
        super(100, 40, 40,30 );
    }
    //Getter
    public String getNombre() {
        return Nombre;
    }
    public int getUsosHabilidades() {
        return UsosHabilidades;
    }
    //Habilidad especial
    public void habilidadEspecial() {
        if (UsosHabilidades != 0) {
            this.Vida += 10;
            this.Ataque += 10;
            UsosHabilidades--;
        }else{
            System.out.println("No quedan Usos para habilidades");
        }
    }

}
