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
public abstract class Pasajeros extends Vehiculo{
    private Integer noPasajeros;
    
    public Pasajeros(String placa, String nserie, String marca, Integer modelo, Double valorFacture, Integer noPasajeros) {
        super(placa, nserie, marca, modelo, valorFacture);
        this.noPasajeros = noPasajeros;
    }

    public Integer getNoPasajeros(){
        return noPasajeros;
    }

    public void setNoPasajeros(Integer noPasajeros){
        this.noPasajeros = noPasajeros;
    }

    @Override
    public Double calcularTenencia(){
        return this.getValorFacture()*calcularBaseGravable();
    }
    
    
}
