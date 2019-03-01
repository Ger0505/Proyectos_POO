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
public class Taxi extends Pasajeros{
    
    private Integer aniosConsesion;
    
    public Taxi(String placa, String nserie, String marca, Integer modelo, Double valorFacture, Integer noPasajeros, Integer aniosConsesion) {
        super(placa, nserie, marca, modelo, valorFacture, noPasajeros);
        this.aniosConsesion = aniosConsesion;
    }

    public Integer getAniosConsesion() {
        return aniosConsesion;
    }

    public void setAniosConsesion(Integer aniosConsesion) {
        this.aniosConsesion = aniosConsesion;
    }

    @Override
    public Double calcularTenencia() {
         return super.calcularTenencia()*(1+(this.getNoPasajeros()/10));
    }
    
    @Override
    public String toString() {
        return super.toString()+"\nimpuesto = "+calcularTenencia();
    }
    
}
