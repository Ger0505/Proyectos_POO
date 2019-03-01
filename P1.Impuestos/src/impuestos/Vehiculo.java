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
public abstract class Vehiculo {
    
    private String placa;
    private String nserie;
    private String marca;
    private Integer modelo;
    private Double valorFacture;

    public Vehiculo(String placa, String nserie, String marca, Integer modelo, Double valorFacture) {
        this.placa = placa;
        this.nserie = nserie;
        this.marca = marca;
        this.modelo = modelo;
        this.valorFacture = valorFacture;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getNserie() {
        return nserie;
    }

    public void setNserie(String nserie) {
        this.nserie = nserie;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Integer getModelo() {
        return modelo;
    }

    public void setModelo(Integer modelo) {
        this.modelo = modelo;
    }

    public Double getValorFacture() {
        return valorFacture;
    }

    public void setValorFacture(Double valorFacture) {
        this.valorFacture = valorFacture;
    }
    
    public abstract Double calcularTenencia();
    
    public Double calcularBaseGravable(){
        return this.modelo<=2009 ? 0.05:0.02;
    }

    @Override
    public String toString() {
        return  "placa=" + placa +
                "\nmarca=" + marca + 
                "\nmodelo=" + modelo;
    }
    
    
    
}
