package model;

import java.time.LocalDate;

/**
 *
 * @author Jorman Noriega, Julio Rios, Andres Contreras, Sergio Arango
 */
public abstract class Egreso {

    //ATRIBUTOS
    private double egreso;
    private String asunto;

    //METODO CONSTRUCTOR
    public Egreso() {
    }

    //METODO CONSTRUCTOR SOBRECARGADO
    public Egreso(double egreso, String asunto) {
        this.egreso = egreso;
        this.asunto = asunto;
    }

    //METODO GET Y SET DE EGRESO
    public double getEgreso() {
        return egreso;
    }

    public void setEgreso(double egreso) {
        this.egreso = egreso;
    }

    //METODO GET Y SET DE ASUNTO
    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    //METODO TOSTRING
    @Override
    public String toString() {
        return "Egreso: " + egreso + "|| Asunto: " + asunto;
    }
}
