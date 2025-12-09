public class Personajes {
    //Default
    private static final Integer Vida_DEF=100;
    private static final Integer Ataque_DEF=30;
    private static final Integer Defensa_DEF=30;
    //atributos
    int Vida;
    int Ataque;
    int Defensa;

    //constructor
    Personajes(int vida, int ataque, int defensa){
        Vida=vida;
        Ataque=ataque;
        Defensa=defensa;
        try{
            if(vida+ataque+defensa>180){}
        }catch (ErrorEstadisticas e){
            System.out.println(e.getMessage());
        }
    }
    Personajes(int vida, int ataque){
        this(vida,ataque,Defensa_DEF);
    }
    Personajes(int vida){
        this(vida, Ataque_DEF, Defensa_DEF);
    }
    Personajes(){
        this(Vida_DEF, Ataque_DEF, Defensa_DEF);;
    }
    //Getters


    public int getVida() {
        return Vida;
    }

    public int getAtaque() {
        return Ataque;
    }

    public int getDefensa() {
        return Defensa;
    }
    // Setters
    public void setVida(int vida) {
        Vida = vida;
    }

    public void setAtaque(int ataque) {
        Ataque = ataque;
    }

    public void setDefensa(int defensa) {
        Defensa = defensa;
    }
    //toString

    @Override
    public String toString() {
        return "Personajes{" +
                "Vida=" + Vida +
                ", Ataque=" + Ataque +
                ", Defensa=" + Defensa +
                '}';
    }
}