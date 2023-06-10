package model;

import java.time.LocalDate;

/**
 *
 * @author Jorman Noriega, Julio Rios, Andres Contreras, Sergio Arango
 */
public class IngresoEventual extends Ingreso {

    //ATRIBUTOS
    private LocalDate fechaIngresoEventual;

    //METODO CONSTRUCTOR
    public IngresoEventual() {
    }

    //METODO CONSTRUCTOR SOBRECARGADO
    public IngresoEventual(double ingreso, String asunto) {
        super(ingreso, asunto);
        this.fechaIngresoEventual = LocalDate.now();
    }

    //METODO GET Y SET DE FECHA INGRESO EVENTUAL
    public LocalDate getFechaIngresoEventual() {
        return fechaIngresoEventual;
    }

    public void setFechaIngresoEventual(LocalDate fechaIngresoEventual) {
        this.fechaIngresoEventual = fechaIngresoEventual;
    }

    //METODO TOSTRING
    @Override
    public String toString() {
        return super.toString() + "|| FechaIngresoEventual: " + fechaIngresoEventual + "\n";
    }

}
