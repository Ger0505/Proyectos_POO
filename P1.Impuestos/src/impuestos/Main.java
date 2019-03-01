/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impuestos;

import impuestos.coleccion.MiArrayList;
import java.util.ArrayList;

/**
 *
 * @author Gerardo A A
 */
public class Main {
    public static void main(String[] args) {
        Particular pa = new Particular("SHDFKHFDSF","FDSHF","LABORGUINI",2012,290000.0,5);
        Taxi taxi = new Taxi("SHDFKHFDSF","FDSHF","LABORGUINI",2012,290000.0,5,10);
        Camion camion = new Camion("1232","100","FERRARI",2019,100000.0,30,true,3);
        Camion camion2 = new Camion("1992","100","FERRARI",2012,105999.0,40,true,5);
        Camioneta camioneta = new Camioneta("SD12","122","CHEBLOLET",2000,90000.0,56, Boolean.FALSE);
        System.out.println(pa.calcularTenencia());
        System.out.println(taxi.calcularTenencia());
        MiArrayList vehiculos = new MiArrayList();
        vehiculos.add(pa);
        vehiculos.add(taxi);
        vehiculos.add(camion);
        vehiculos.add(camion2);
        vehiculos.add(camioneta);
        Integer cont=0;
        for(Vehiculo v : vehiculos){
            System.out.println("Vehiculo No."+(++cont));
            System.out.println(v);
            
        }
        
    }
}
