package model;

import java.time.LocalDate;

/**
 *
 * @author Jorman Noriega, Julio Rios, Andres Contreras, Sergio Arango
 */
public class EgresoFijo extends Egreso {

    //ATRIBUTOS
    private LocalDate fechaInicioEgresoFijo;
    private int frecuenciaEgresoFijo;

    //METODO CONSTRUCTOR
    public EgresoFijo() {
    }

    //METODO CONSTRUCTOR SOBRECARGADO
    public EgresoFijo(int frecuenciaEgresoFijo, LocalDate fechaInicioEgresoFijo, double egreso, String asunto) {
        super(egreso, asunto);
        this.fechaInicioEgresoFijo = fechaInicioEgresoFijo;
        this.frecuenciaEgresoFijo = frecuenciaEgresoFijo;
    }

    //METODO GET Y SEY DE FECHA INICIO EGRESO FIJO
    public LocalDate getFechaInicioEgresoFijo() {
        return fechaInicioEgresoFijo;
    }

    public void setFechaInicioEgresoFijo(LocalDate fechaInicioEgresoFijo) {
        this.fechaInicioEgresoFijo = fechaInicioEgresoFijo;
    }

    //METODO GET Y SET DE FRECUENCIA EGRESO FIJO
    public int getFrecuenciaEgresoFijo() {
        return frecuenciaEgresoFijo;
    }

    public void setFrecuenciaEgresoFijo(int frecuenciaEgresoFijo) {
        this.frecuenciaEgresoFijo = frecuenciaEgresoFijo;
    }

    //METODO TOSTRING
    @Override
    public String toString() {
        return super.toString() + "|| Inicio Del Egreso Fijo: " + fechaInicioEgresoFijo + "|| Frecuencia Del Egreso Fijo: " + frecuenciaEgresoFijo;
    }

}
