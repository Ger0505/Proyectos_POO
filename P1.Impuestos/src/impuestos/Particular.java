/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impuestos;

/**
 *
 * @author Gerardo A A
 */
public class Particular extends Pasajeros{
    
    public Particular(String placa, String nserie, String marca, Integer modelo, Double valorFacture, Integer noPasajeros) {
        super(placa, nserie, marca, modelo, valorFacture, noPasajeros);
    }
    
    @Override
    public String toString() {
        return super.toString()+"\nimpuesto = "+calcularTenencia();
    }
    
}
