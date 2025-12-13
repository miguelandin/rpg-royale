public class Personajes {
    //Default
    private static final Integer Vida_DEF=100;
    private static final Integer Ataque_DEF=30;
    private static final Integer ARMADURA_DEF =30;
    private static final Integer VELOCIDAD_DEF =30;
    //atributos
    int Vida;
    int Ataque;
    int Armadura;
    int Velocidad;

    //constructor
    Personajes(int vida, int ataque, int armadura, int velocidad) {
        Vida=vida;
        Ataque=ataque;
        Armadura = armadura;
        Velocidad=velocidad;
        try{
            if(vida+ataque+armadura >180){}
        }catch (ErrorEstadisticas e){
            System.out.println(e.getMessage());
        }
    }
    Personajes(int vida, int ataque, int armadura){
        this(vida,ataque, armadura, VELOCIDAD_DEF);
    }
    Personajes(int vida, int ataque){
        this(vida, ataque, ARMADURA_DEF, VELOCIDAD_DEF);
    }
    Personajes(int vida){this(vida, Ataque_DEF, ARMADURA_DEF, VELOCIDAD_DEF);;}
    Personajes(){this(Vida_DEF, Ataque_DEF, ARMADURA_DEF, VELOCIDAD_DEF);}
    //Getters


    public int getVida() {
        return Vida;
    }

    public int getAtaque() {
        return Ataque;
    }

    public int getArmadura() {
        return Armadura;
    }
    public int getVelocidad() {
        return Velocidad;
    }
    // Setters
    public void setVida(int vida) {
        Vida = vida;
    }

    public void setAtaque(int ataque) {
        Ataque = ataque;
    }

    public void setArmadura(int armadura) {
        Armadura = armadura;
    }
    public void setVelocidad(int velocidad) {
        Velocidad = velocidad;
    }
    //toString

    @Override
    public String toString() {
        return "Personajes{" +
                "Vida=" + Vida +
                ", Ataque=" + Ataque +
                ", Defensa=" + Armadura +
                '}';
    }
}