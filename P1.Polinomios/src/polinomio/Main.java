package polinomio;

/**
 *
 * @author Gerardo A A
 */
public class Main {
    
    public static void main(String[] args) {
        Polinomio p1 = new Polinomio();
        p1.add(new Monomio(1,5));
        p1.add(new Monomio(2,3));
        p1.add(new Monomio(-1,1));
        p1.add(new Monomio(-8,0));
        Polinomio p2 = new Polinomio();
        p2.add(new Monomio(1,2));
        p2.add(new Monomio(-2,1));
        p2.add(new Monomio(1,0));
        System.out.println("Polinomios:");
        p1.imprimir();
        p2.imprimir();
        System.out.println("...............");
        System.out.println("Suma:");
        Polinomio.sumar(p1, p2);
        System.out.println("...............");
        System.out.println("Resta:");
        Polinomio.restar(p1, p2);
        System.out.println("...............");
        System.out.println("Multiplicación:");
        Polinomio.multiplicar(p1, p2);
        System.out.println("...............");
        System.out.println("División:");
        Polinomio.dividir(p1, p2);
        System.out.println("...............");
        ///------------------
        Polinomio poli1 = new Polinomio();
        poli1.add(new Monomio(2,3));
        poli1.add(new Monomio(4,2));
        poli1.add(new Monomio(-5,0));
        Polinomio poli2 = new Polinomio();
        poli2.add(new Monomio(1,2));
        poli2.add(new Monomio(3,0));
        System.out.println("");
        poli1.imprimir();
        poli2.imprimir();
        Polinomio.dividir(poli1,poli2);
        poli1.imprimir();
        poli2.imprimir();
        
    }
}
