package model;

import java.time.LocalDate;

/**
 *
 * @author Jorman Noriega, Julio Rios, Andres Contreras, Sergio Arango
 */
public class IngresoFijo extends Ingreso {

    //ATRIBUTOS
    private LocalDate fechaInicioIngresoFijo;
    private int frecuenciaIngresoFijo;

    //METODO CONSTRUCTOR
    public IngresoFijo() {
    }

    //METODO CONSTRUCTOR SOBRECARGADO
    public IngresoFijo(int frecuenciaIngresoFijo, LocalDate fechaInicioIngresoFijo, double ingreso, String asunto) {
        super(ingreso, asunto);
        this.fechaInicioIngresoFijo = fechaInicioIngresoFijo;
        this.frecuenciaIngresoFijo = frecuenciaIngresoFijo;
    }

    //METODO GET Y SET DE FECHA INICIO INGRESO FIJO
    public LocalDate getFechaInicioIngresoFijo() {
        return fechaInicioIngresoFijo;
    }

    public void setFechaInicioIngresoFijo(LocalDate fechaInicioIngresoFijo) {
        this.fechaInicioIngresoFijo = fechaInicioIngresoFijo;
    }

    //METODO GET Y SET DE FRECUENCIA INGRESO FIJO
    public int getFrecuenciaIngresoFijo() {
        return frecuenciaIngresoFijo;
    }

    public void setFrecuenciaIngresoFijo(int frecuenciaIngresoFijo) {
        this.frecuenciaIngresoFijo = frecuenciaIngresoFijo;
    }

    //METODO TOSTRING
    @Override
    public String toString() {
        return super.toString() + "|| Inicio Del Ingreso Fijo: " + fechaInicioIngresoFijo + "|| Frecuencia Del Ingreso Fijo: " + frecuenciaIngresoFijo;
    }

}
