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
       
       return this.precioKm * (this.kmDevolucion - this.kmRenta);
   
   }  

    @Override
    public String getInfo() {
        return " || Precio km: " + this.precioKm + 
               " || Km renta:  " + this.kmRenta +  
               " || Km devolucion: " + this.kmDevolucion;  
    }
    
    @Override
    public String getDataFileFormat(){
        
        return this.getPlaca()+";"+
               "A"+";"+
               this.precioKm+";"+
               this.kmRenta+";"+
               this.kmDevolucion+";"+
               this.calcularImporteRenta();
    
    }

    @Override
    public String[] getDataForTable() {
       String data[] = {this.getPlaca(), 
                        "Autobus", 
                        String.valueOf(this.precioKm), 
                        String.valueOf(this.kmRenta), 
                        String.valueOf(this.kmDevolucion),
                        "","","",
                        String.valueOf(this.calcularImporteRenta())
                       };
       return data;
    }
    
}
