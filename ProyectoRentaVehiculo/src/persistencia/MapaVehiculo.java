/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import modelo.Vehiculo;

/**
 *
 * @author Jairo F
 */
public class MapaVehiculo implements IRenta {
    
    private Map<String, Vehiculo> mapa;

    public MapaVehiculo() {
        this.mapa = new HashMap();
    }
    
    
    @Override
    public void registraVehiculo(Vehiculo v) {
        this.mapa.put(v.getPlaca(), v);
    }

    @Override
    public Vehiculo buscarVehiculo(String placa) {
         Vehiculo v = this.mapa.get(placa);
         return v;
    }

    @Override
    public List<Vehiculo> informeRenta() {
        
        List<Vehiculo> lista = new ArrayList();
        for(Map.Entry e: this.mapa.entrySet()){
            lista.add((Vehiculo)e.getValue());
        }
        return lista;
    }
    
}
