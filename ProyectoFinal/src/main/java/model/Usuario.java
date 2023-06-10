package model;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Jorman Noriega, Julio Rios, Andres Contreras, Sergio Arango
 */
public class Usuario {

    //ATRIBUTOS
    
    private String nombre;
    private String correo;
    private String contraseña;
    private double saldo;
    private ArrayList<Ingreso> ingresos;
    private ArrayList<Egreso> egresos;

    //METODO CONSTRUCTOR
    public Usuario() {
    }

    //METODO CONSTRUCTOR SOBRECARGADO
    public Usuario(String nombre, String correo, String contraseña) {
        this.nombre = nombre;
        this.correo = correo;
        this.contraseña = contraseña;
        this.ingresos = new ArrayList();
        this.egresos = new ArrayList();
    }

    //METODO GET Y SET DE NOMBRE
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //METODO GET Y SET DE CORREO
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    //METODO GET Y SET DE CONTRASEÑA
    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    //METODO GET Y SET DE SALDO
    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    //METODO GET Y SET DE ARRAYLIST INGRESOS
    public ArrayList<Ingreso> getIngresos() {
        return ingresos;
    }

    public void setIngresos(ArrayList<Ingreso> ingresos) {
        this.ingresos = ingresos;
    }

    //METODO GET Y SET DE ARRAYLIST EGRESOS
    public ArrayList<Egreso> getEgresos() {
        return egresos;
    }

    public void setEgresos(ArrayList<Egreso> egresos) {
        this.egresos = egresos;
    }

    //METODO REGISTRAR INGRESO FIJO
    public void registrarIngresoFijo(double ingreso, String asunto, int frecuencia, LocalDate inicio) {
        this.ingresos.add(new IngresoFijo(frecuencia, inicio, ingreso, asunto));
    }
    
    //METODO REGISTRAR INGRESO EVENTUAL
    public void registrarIngresoEventual(double ingreso, String asunto) {
        this.ingresos.add(new IngresoEventual(ingreso, asunto));
        this.saldo += ingreso;
    }

    //METODO REGISTRAR EGRESO FIJO
    public void registrarEgresoFijo(double ingreso, String asunto, int frecuencia, LocalDate inicio) {
        Egreso nuevoEgreso = new EgresoFijo(frecuencia, inicio, ingreso, asunto);
        this.egresos.add(nuevoEgreso);
    }

    //METODO REGISTRAR EGRESO EVENTUAL
    public void registrarEgresoEventual(double egreso, String asunto) {
        Egreso nuevoEgreso = new EgresoEventual(egreso, asunto);
        this.egresos.add(nuevoEgreso);
        this.saldo -= egreso;
    }
}
