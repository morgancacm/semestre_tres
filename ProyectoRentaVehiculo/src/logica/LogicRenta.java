/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.io.IOException;
import java.util.List;
import modelo.Vehiculo;
import persistencia.ArchivoObjetos;
import persistencia.ArchivoTexto;
import persistencia.IRenta;
import persistencia.ListaVehiculo;
import persistencia.MapaVehiculo;

/**
 *
 * @author Jairo F
 */
public class LogicRenta {
    
    private IRenta datos;

    public LogicRenta() {
       // this.datos = new ListaVehiculo();
       // this.datos = new MapaVehiculo();
       //this.datos = new ArchivoTexto();
       this.datos = new  ArchivoObjetos();
    }
    
    
    public void rentarVehiculo(Vehiculo v) throws IOException{
        this.datos.registraVehiculo(v);
    }
    
    public Vehiculo buscarRentado(String placa) throws IOException{
         return this.datos.buscarVehiculo(placa);
    }
    
    public List<Vehiculo> informeRentas() throws IOException{
        
        return this.datos.informeRenta();
    }
    
}
