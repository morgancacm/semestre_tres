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
        
        Duration duracion = Duration.between(this.fechaRenta.atStartOfDay(), this.fechaDevolucion.atStartOfDay());
        int dias = (int)duracion.toDays();
        
        return this.precioDia * dias;
    
    }
    
    @Override
    public String getInfo() {
        return " || " + "Precio Dia="+ this.precioDia + 
               " || " + "Fecha Renta=" + this.fechaRenta.toString() + 
               " || " + "Fecha Devolucion="+this.fechaDevolucion.toString();       
    }
    
}
