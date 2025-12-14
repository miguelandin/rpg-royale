public class Tanque extends Personajes{
    //Atributos
    private String Nombre="Tanque";
    private int UsosHabilidades=2;
    //Constructor
    Tanque(){
        super(100, 20, 60,30 );
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
            this.Armadura += 10;
            UsosHabilidades--;
        }else{
            System.out.println("No quedan Usos para habilidades");
        }
    }
}
