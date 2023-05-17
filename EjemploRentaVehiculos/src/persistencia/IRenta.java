/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia;

import java.util.List;
import modelo.Vehiculo;

/**
 *
 * @author Jairo F
 */
public interface IRenta {
    void registrarVehiculo(Vehiculo v);
    Vehiculo buscarVehiculoPorPlaca(String placa);
    List<Vehiculo> listRentados();
}
