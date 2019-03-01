package polinomio;

/**
 * Crea un monomio usualmente para utilizarlo en un polinomio
 * @author Gerardo A A
 */
public class Monomio {
    
    public static final Character VARIABLE = 'x';
    
    private Integer exponente;
    private Integer coeficiente;

    public Monomio(Integer coeficiente,Integer exponente) {
        this.exponente = exponente;
        this.coeficiente = coeficiente;
    }
    
    //Patrón de diseño: singleton
    /**
     * Es el numerito que tiene nuestra variable
     * @return exponente
     */
    public Integer getExponente() {
        return exponente;
    }

    public void setExponente(Integer exponente) {
        this.exponente = exponente;
    }
    
    /**
     * Es una constante que multiplica a nuestra variable
     * @return coeficiente 
     */
    public Integer getCoeficiente() {
        return coeficiente;
    }
    
    public void setCoeficiente(Integer coeficiente) {
        this.coeficiente = coeficiente;
    }
    
    public Boolean isSemenjante(Monomio mo){
        return this.exponente== mo.getExponente();
    }

    @Override
    public String toString() {
       if(exponente!=0){
           return (coeficiente>0 ? "+":"")+(coeficiente!=1 ? coeficiente:"")+VARIABLE+(exponente!=1 ? "^"+exponente:"");
       }else
       return (coeficiente>0 ? "+":"")+coeficiente;
    }
    
    
    
}
