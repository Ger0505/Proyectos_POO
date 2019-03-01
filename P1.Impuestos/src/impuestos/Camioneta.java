package impuestos;

/**
 *
 * @author Gerardo A A
 */
public class Camioneta extends Carga{

    public Camioneta(String placa, String nserie, String marca, Integer modelo, Double valorFacture, Integer tolenadas, Boolean publico) {
        super(placa, nserie, marca, modelo, valorFacture, tolenadas, publico);
    }
    
    @Override
    public String toString() {
        return super.toString()+"\nimpuesto = "+calcularTenencia();
    }
    
}
