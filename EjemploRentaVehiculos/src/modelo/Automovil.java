/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Jairo F
 */
public class Automovil extends Vehiculo{
    
    private double precioHora;
    private int horasRenta;

    public Automovil() {
    }

    public Automovil(double precioHora, int horasRenta, String placa, boolean estado) {
        super(placa, estado);
        this.precioHora = precioHora;
        this.horasRenta = horasRenta;
    }

    /**
     * @return the precioHora
     */
    public double getPrecioHora() {
        return precioHora;
    }

    /**
     * @param precioHora the precioHora to set
     */
    public void setPrecioHora(double precioHora) {
        this.precioHora = precioHora;
    }

    /**
     * @return the horasRenta
     */
    public int getHorasRenta() {
        return horasRenta;
    }

    /**
     * @param horasRenta the horasRenta to set
     */
    public void setHorasRenta(int horasRenta) {
        this.horasRenta = horasRenta;
    }

    @Override
    public double calcularImporteRenta() {
        return this.horasRenta * this.precioHora;
    }

    @Override
    public String getInfo() {
        return " || " +  "Precio hora: " + this.precioHora + 
               " || " +  "No Horas:" + this.horasRenta; 
    }
    
    
}
