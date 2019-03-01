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
public class Camion extends Carga{
    
    private Integer ejes;
    
    public Camion(String placa, String nserie, String marca, Integer modelo, Double valorFacture, Integer tolenadas, Boolean publico,Integer ejes) {
        super(placa, nserie, marca, modelo, valorFacture, tolenadas, publico);
        this.ejes = ejes;
    }

    @Override
    public Double calcularBaseGravable() {
        return super.calcularBaseGravable()*(1+(ejes*0.001));
    }

    @Override
    public String toString() {
        return super.toString()+"\nimpuesto = "+calcularTenencia();
    }
    
    
    
}
