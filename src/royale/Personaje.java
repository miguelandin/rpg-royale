package royale;

public abstract class Personaje implements Comparable<Personaje>{
    protected Integer vida;
    protected Integer daño;
    protected Integer armadura;
    protected Integer suerte; // multiplicador de daño cuando hay crítico
    protected Integer usos;
    protected String nombre;
 
    private static final Integer MAX_STATS = 180;
    private static final Integer CURACION_DEFAULT = 30;
    
    protected Personaje(Integer vida, Integer daño, Integer armadura, Integer suerte, String nombre, Integer usos) throws ErrorEstadisticas{
    	if(vida + daño + armadura + suerte > MAX_STATS)
    		throw new ErrorEstadisticas();
    	
        this.vida = vida;
        this.daño = daño;
        this.armadura = armadura;
        this.suerte = suerte;
        this.nombre = nombre;
        this.usos = usos;
    }
    
    // Getters
    public Integer getVida() {
        return vida;
    }

    public Integer getDaño() {
        return daño;
    }

    public Integer getArmadura() {
        return armadura;
    }
    
    public Integer getSuerte() {
        return suerte;
    }
    
    public Integer getUsos() {
    	return usos;
    }
    
    public String getNombre() {
    	return nombre;
    }
    
    // Setters
    public void setVida(Integer vida) {
        this.vida = vida;
    }

    public void setDaño(Integer daño) {
        this.daño = daño;
    }

    public void setArmadura(Integer armadura) {
        this.armadura = armadura;
    }
    
    public void setSuerte(Integer suerte) {
        this.suerte = suerte;
    }
    
    public void setUsos(Integer usos) {
    	this.usos = usos;
    }
    
    public boolean habilidadEspecial() {
    	return false;
    }
    
    public Integer curar() {
    	this.vida += CURACION_DEFAULT;
    	return CURACION_DEFAULT;
    }

    @Override
    public String toString() {
        return nombre +"{" + "Vida=" + this.vida + ", Ataque=" + this.daño + ", Defensa=" + this.armadura + ", Suerte=" + this.suerte +"}";
    }
    
    @Override
    public int compareTo(Personaje otroPersonaje) {
    	return this.daño.compareTo(otroPersonaje.getDaño());
    }
}