/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import modelo.Vehiculo;

/**
 *
 * @author Jairo F
 */
public class ListaVehiculo implements IRenta, Serializable {

    private List<Vehiculo> lista;

    public ListaVehiculo() {
        this.lista = new ArrayList();
    }
    
    
    @Override
    public void registraVehiculo(Vehiculo v) {
        this.lista.add(v);
       
    }

    @Override
    public Vehiculo buscarVehiculo(String placa) {
        for (Vehiculo v : lista) {
            if (v.getPlaca().equalsIgnoreCase(placa)) {
                return v;
            }

        }
        return null;
    }

    @Override
    public List<Vehiculo> informeRenta() {
        return this.lista;
    }
    
}
