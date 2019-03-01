/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impuestos.coleccion;

import impuestos.Vehiculo;
import java.util.ArrayList;

/**
 *
 * @author Gerardo A A
 */
public class MiArrayList extends ArrayList<Vehiculo>{

    @Override
    public boolean add(Vehiculo vehiculo) {
        if(constains(vehiculo)) 
            return true;
        else
            return  super.add(vehiculo);
    }
    
    private boolean constains(Vehiculo vehiculo){
        boolean encontrado = false;
        int contador = 0;
        while(!encontrado && contador<this.size()){
            encontrado = (this.get(contador).getPlaca().equals(vehiculo.getPlaca())) || 
                         (this.get(contador).getNserie().equals(vehiculo.getNserie()));
            contador++;
        }
        return encontrado;
    }

    
    
    
}
