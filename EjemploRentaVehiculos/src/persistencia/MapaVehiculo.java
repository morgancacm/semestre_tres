/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import modelo.Vehiculo;

/**
 *
 * @author Jairo F
 */
public class MapaVehiculo implements IRenta {
    private Map<String, Vehiculo> map ;

    public MapaVehiculo() {
        this.map = new HashMap();
    }

    
    @Override
    public void registrarVehiculo(Vehiculo v) {
        
        this.map.put(v.getPlaca(), v);
        
    }

    @Override
    public Vehiculo buscarVehiculoPorPlaca(String placa) {
        return this.map.get(placa);
    }

    @Override
    public List<Vehiculo> listRentados() {
        
        List<Vehiculo> vehiculos = new ArrayList();
        Iterator<String> i = this.map.keySet().iterator();
        while(i.hasNext()){
            String key = i.next();
            Vehiculo v = this.map.get(key);
            vehiculos.add(v);
        }
        return vehiculos;
    }
    
}
