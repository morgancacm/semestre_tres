/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.time.Duration;
import java.time.LocalDate;

/**
 *
 * @author Jairo F
 */
public class Tractor extends Vehiculo {
    
    private double precioDia;
    private LocalDate fechaRenta;
    private LocalDate fechaDevolucion;

    public Tractor() {
    }

    public Tractor(double precioDia, LocalDate fechaRenta, LocalDate fechaDevolucion, String placa, boolean estado) {
        super(placa, estado);
        this.precioDia = precioDia;
        this.fechaRenta = fechaRenta;
        this.fechaDevolucion = fechaDevolucion;
    }

    /**
     * @return the precioDia
     */
    public double getPrecioDia() {
        return precioDia;
    }

    /**
     * @param precioDia the precioDia to set
     */
    public void setPrecioDia(double precioDia) {
        this.precioDia = precioDia;
    }

    /**
     * @return the fechaRenta
     */
    public LocalDate getFechaRenta() {
        return fechaRenta;
    }

    /**
     * @param fechaRenta the fechaRenta to set
     */
    public void setFechaRenta(LocalDate fechaRenta) {
        this.fechaRenta = fechaRenta;
    }

    /**
     * @return the fechaDevolucion
     */
    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    /**
     * @param fechaDevolucion the fechaDevolucion to set
     */
    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }
    
    @Override
    public double calcularImporteRenta(){
        Duration diferencia = Duration.between(fechaRenta.atStartOfDay(), fechaDevolucion.atStartOfDay());
        int nDias = (int) diferencia.toDays();
        
        return this.precioDia * nDias;
    
    }

    @Override
    public String getInfo() {
        return " || Precio dia: " + this.precioDia + 
               " || Fecha renta: " + this.fechaRenta.toString() +  
               " || Fecha devolucion: " + this.fechaDevolucion.toString();  
    }

    @Override
    public String getDataFileFormat() {
        return this.getPlaca()+";"
                +"T;"+this.getPrecioDia()+";"
                +this.fechaRenta + ";"
                +this.fechaDevolucion+ ";"
                +this.calcularImporteRenta();
                
    }
    
    @Override
    public String[] getDataForTable() {
       String data[] = {this.getPlaca(), 
                        "Tractor", 
                        "","","",
                        String.valueOf(this.precioDia), 
                        this.fechaRenta.toString(), 
                        this.fechaDevolucion.toString(),
                        String.valueOf(this.calcularImporteRenta())
                       };
       return data;
    }
    
}
