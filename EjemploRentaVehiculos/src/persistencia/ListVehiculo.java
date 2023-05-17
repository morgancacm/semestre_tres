/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.util.ArrayList;
import java.util.List;
import modelo.Vehiculo;

/**
 *
 * @author Jairo F
 */
public class ListVehiculo implements IRenta {

    private List<Vehiculo> list;

    public ListVehiculo() {
        this.list = new ArrayList();
    }
    
    
    @Override
    public void registrarVehiculo(Vehiculo v) {
       this.list.add(v);
    }

    @Override
    public Vehiculo buscarVehiculoPorPlaca(String placa) {
        for(Vehiculo v: list){
            if(v.getPlaca().equalsIgnoreCase(placa)){
                return v;
            }
        }
        return null;
    }

    @Override
    public List<Vehiculo> listRentados() {
        return this.list;
    }
    
}
