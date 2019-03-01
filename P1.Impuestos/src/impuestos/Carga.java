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
public abstract class Carga extends Vehiculo{
    
    private Integer toneladas;
    private Boolean publico;

    public Carga(String placa, String nserie, String marca, Integer modelo, Double valorFacture,Integer tolenadas,Boolean publico) {
        super(placa, nserie, marca, modelo, valorFacture);
        this.toneladas = tolenadas;
        this.publico = publico;
    }

    public Integer getToneladas() {
        return toneladas;
    }

    public void setToneladas(Integer toneladas) {
        this.toneladas = toneladas;
    }

    public Boolean getPublico() {
        return publico;
    }

    public void setPublico(Boolean publico) {
        this.publico = publico;
    }

    @Override
    public Double calcularBaseGravable() {
        if(!this.publico)
            return super.calcularBaseGravable();
        else{
            return this.getModelo() >= 2009 ? 0.03:0.01;
        }
            
    }
    
    @Override
    public Double calcularTenencia(){
        return this.getValorFacture()*(1+getToneladas()/10)*calcularBaseGravable();
    }
    
    
    
}
