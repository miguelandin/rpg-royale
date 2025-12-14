public class Asesino extends Personajes{
    //Atributos
    private String Nombre="Asesino";
    private int UsosHabilidades=2;
    //Constructor
    Asesino(){
        super(100, 60, 10,50 );
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
            this.Ataque += 10;
            this.Velocidad += 10;
            UsosHabilidades--;
        }else{
            System.out.println("No quedan Usos para habilidades");
        }
    }

}