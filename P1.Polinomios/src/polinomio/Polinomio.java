package polinomio;

import java.util.ArrayList;

/**
 * Crea una operación algebraica con polinomios
 * @author Gerardo A A
 */
public class Polinomio {
    private ArrayList<Monomio> terminos;

    public Polinomio() {
        terminos = new ArrayList<>();
    }

    public ArrayList<Monomio> getTerminos() {
        return terminos;
    }
    
    public void add(Monomio mono){
        terminos.add(mono);
    }
 
    /**
     * Imprime la suma de los dos polinomios
     * @param p1
     * @param p2 
     */
    public static void sumar(Polinomio p1,Polinomio p2){
        ArrayList<Monomio> resultado = new ArrayList<>();
        for(Monomio p: p1.getTerminos()){
            resultado.add(new Monomio(p.getCoeficiente(),p.getExponente()));
        }
        for(Monomio p: p2.getTerminos()){
            resultado.add(new Monomio(p.getCoeficiente(),p.getExponente()));
        }
        resultado = Polinomio.reducir(resultado);
        ordenar(resultado);
        imprimir(resultado);
    }
    
    /**
     * Imprime la resta de los dos polinomios
     * @param p1
     * @param p2 
     */
    public static void restar(Polinomio p1,Polinomio p2){
       ArrayList<Monomio> resultado = new ArrayList<>();
        for(Monomio p: p1.getTerminos()){
            resultado.add(new Monomio(p.getCoeficiente(),p.getExponente()));
        }
        for(Monomio p: p2.getTerminos()){
            resultado.add(new Monomio(-p.getCoeficiente(),p.getExponente()));
        }
        resultado = Polinomio.reducir(resultado);
        ordenar(resultado);
        imprimir(resultado);
    }
    
    private static ArrayList<Monomio> restar(ArrayList<Monomio> p1,ArrayList<Monomio> p2){
       ArrayList<Monomio> aux = new ArrayList<>();
        for(Monomio p: p1){
            aux.add(new Monomio(p.getCoeficiente(),p.getExponente()));
        }
        for(Monomio p: p2){
            aux.add(new Monomio(-p.getCoeficiente(),p.getExponente()));
        }
        aux = Polinomio.reducir(aux);
        
        return aux;
    }
    
    /**
     * Imprime la multiplicación del polinomio
     * @param p1
     * @param p2 
     */
    public static void multiplicar(Polinomio p1,Polinomio p2){
       ArrayList<Monomio> resultado = new ArrayList<>();
       ArrayList<Monomio> array1 = p1.getTerminos();
       ArrayList<Monomio> array2 = p2.getTerminos();
       Integer point1 = array1.size()-1;
       Integer point2 = array2.size()-1;
       Monomio aux1,aux2;
       while(point2 >=0){
            point1 = array1.size()-1;
            aux2 = array2.get(point2--);
            while(point1 >= 0){
                aux1 = array1.get(point1--);
                Integer coef = aux1.getCoeficiente()*aux2.getCoeficiente();
                Integer expo = aux1.getExponente()+aux2.getExponente();
                resultado.add(new Monomio(coef, expo));
            }
       } 
       resultado = Polinomio.reducir(resultado);
        ordenar(resultado);
       imprimir(resultado);
    }
    
    private static ArrayList<Monomio> multiplicarMonomio(ArrayList<Monomio> poli,Monomio mono){
        ArrayList<Monomio> aux = new ArrayList<>();
        for(Monomio m:poli){
            aux.add(new Monomio(m.getCoeficiente()*mono.getCoeficiente(),m.getExponente()+mono.getExponente()));
        }
        return aux;
    }
    
    /**
     * Imprime el cociente de la división de los dos polinomios
     * e imprime el residuo
     * @param p1
     * @param p2 
     */
    public static void dividir(Polinomio p1,Polinomio p2){
       ArrayList<Monomio> dividendo = p1.getTerminos();
       ArrayList<Monomio> divisor = p2.getTerminos();
       ArrayList<Monomio> cociente = new ArrayList<>();
       
       while(dividendo.get(0).getExponente()>=divisor.get(0).getExponente()){
           Monomio aux = dividirMonomio(dividendo.get(0),divisor.get(0));
           cociente.add(aux);
           ArrayList<Monomio> restor = multiplicarMonomio(divisor,aux);
           dividendo = Polinomio.restar(dividendo,restor);
           ordenar(dividendo);
       }
        
        imprimir(cociente);
        System.out.print("Residuo: ");
        imprimir(dividendo);
    }
    
    private static Monomio dividirMonomio(Monomio m1,Monomio m2){
        return new Monomio(m1.getCoeficiente()/m2.getCoeficiente(),m1.getExponente()-m2.getExponente());
    }
    
    public void reducir(){
        ArrayList<Monomio> aux = new ArrayList<>();
       
        while(terminos.size()>0){
            Monomio  actual = terminos.remove(0);
            int cont = 0;
            while(cont<terminos.size()){
                Monomio t = terminos.get(cont);
                if(actual.isSemenjante(t)){
                    actual.setCoeficiente(actual.getCoeficiente()+t.getCoeficiente());
                    terminos.remove(cont);
                }else 
                    cont++;
            }
            if(actual.getCoeficiente()!=0)
                aux.add(actual);
            cont=0;
        }
        for(Monomio m:aux){
            terminos.add(m);
        }
    }
    
    private static ArrayList<Monomio> reducir(ArrayList<Monomio> p){
        ArrayList<Monomio> aux = new ArrayList<>();     
        while(p.size()>0){
            Monomio  actual = p.remove(0);
            int cont = 0;
            while(cont<p.size()){
                Monomio t = p.get(cont);
                if(actual.isSemenjante(t)){
                    actual.setCoeficiente(actual.getCoeficiente()+t.getCoeficiente());
                    p.remove(cont);
                }else 
                    cont++;
            }
            if(actual.getCoeficiente()!=0)
                aux.add(actual);
            cont=0;
        }
        for(Monomio m:aux){
            p.add(m);
        }
        return p;
    }
    
    public void ordenar(){
        Monomio aux = null;
        for(int i =0;i<terminos.size()-1;i++){
            for(int j =0;j<terminos.size()-1;j++){
                if(terminos.get(j).getExponente()<terminos.get(j+1).getExponente()){
                    aux = terminos.get(j);
                    terminos.set(j,terminos.get(j+1));
                    terminos.set(j+1, aux);
                }
            }
        }
    }
    
    public static void ordenar(ArrayList<Monomio> terminos){
        Monomio aux = null;
        for(int i =0;i<terminos.size()-1;i++){
            for(int j =0;j<terminos.size()-1;j++){
                if(terminos.get(j).getExponente()<terminos.get(j+1).getExponente()){
                    aux = terminos.get(j);
                    terminos.set(j,terminos.get(j+1));
                    terminos.set(j+1, aux);
                }
            }
        }       
    }
    
    public void imprimir(){
        for(Monomio m:terminos){
            System.out.print(m.toString());
        }
        System.out.println("");
    }
    
    private static void imprimir(ArrayList<Monomio> array){
        for(Monomio m:array){
            System.out.print(m.toString());
        }
        System.out.println("");
    }
    
    public void resolver(){
        ArrayList<Integer> numeros = new ArrayList<>();
        
    }
}