package model;

import java.time.LocalDate;

/**
 *
 * @author Jorman Noriega, Julio Rios, Andres Contreras, Sergio Arango
 */
public class EgresoEventual extends Egreso {

    //ATRIBUTOS
    private LocalDate fechaEgresoEventual;

    //METODO CONSTRUCTOR
    public EgresoEventual() {
    }

    //METODO CONSTRUCTOR SOBRECARGADO
    public EgresoEventual(double egreso, String asunto) {
        super(egreso, asunto);
        this.fechaEgresoEventual = LocalDate.now();
    }

    //METODO GET Y SET DE FECHA EGRESO EVENTUAL
    public LocalDate getFechaEgresoEventual() {
        return fechaEgresoEventual;
    }

    public void setFechaEgresoEventual(LocalDate fechaEgresoEventual) {
        this.fechaEgresoEventual = fechaEgresoEventual;
    }

    //METODO TOSTRING
    @Override
    public String toString() {
        return super.toString() + "|| Fecha Egreso Eventual: " + fechaEgresoEventual;
    }
}
