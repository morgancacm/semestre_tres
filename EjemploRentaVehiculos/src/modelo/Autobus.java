/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Jairo F
 */
public class Autobus extends Vehiculo {
    
    private double precioKm;
    private double kmRenta;
    private double kmDevolucion;

    public Autobus() {
    }

    public Autobus(double precioKm, double kmRenta, double kmDevolucion, String placa, boolean estado) {
        super(placa, estado);
        this.precioKm = precioKm;
        this.kmRenta = kmRenta;
        this.kmDevolucion = kmDevolucion;
    }

    /**
     * @return the precioKm
     */
    public double getPrecioKm() {
        return precioKm;
    }

    /**
     * @param precioKm the precioKm to set
     */
    public void setPrecioKm(double precioKm) {
        this.precioKm = precioKm;
    }

    /**
     * @return the kmRenta
     */
    public double getKmRenta() {
        return kmRenta;
    }

    /**
     * @param kmRenta the kmRenta to set
     */
    public void setKmRenta(double kmRenta) {
        this.kmRenta = kmRenta;
    }

    /**
     * @return the kmDevolucion
     */
    public double getKmDevolucion() {
        return kmDevolucion;
    }

    /**
     * @param kmDevolucion the kmDevolucion to set
     */
    public void setKmDevolucion(double kmDevolucion) {
        this.kmDevolucion = kmDevolucion;
    }
    
    @Override
    public double calcularImporteRenta(){
        
        return (this.kmDevolucion - this.kmRenta) * this.precioKm;
    
    }

    @Override
    public String getInfo() {
        return " || " + "Precio KM="+ this.precioKm + 
               " || " + "Km Renta=" + this.kmRenta + 
               " || " + "Km Devolucion="+this.kmDevolucion;       
    }
    
}
