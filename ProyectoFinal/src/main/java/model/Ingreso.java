package model;

import java.time.LocalDate;

/**
 *
 * @author Jorman Noriega, Julio Rios, Andres Contreras, Sergio Arango
 */
public abstract class Ingreso {

    //ATRIBUTOS
    private double ingreso;
    private String asunto;
    

    //METODO CONSTRUCTOR
    public Ingreso() {
    }

    //METODO CONSTRUCTOR SOBRECARGADO
    public Ingreso(double ingreso, String asunto) {
        this.ingreso = ingreso;
        this.asunto = asunto;
        
    }

    //METODO GET Y SET DE INGRESO
    public double getIngreso() {
        return ingreso;
    }

    public void setIngreso(double ingreso) {
        this.ingreso = ingreso;
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
        return "Ingreso: " + ingreso + "|| Asunto: " + asunto;
    }
}
