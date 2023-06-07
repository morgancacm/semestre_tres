/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia;

import java.io.IOException;
import java.util.List;
import modelo.Vehiculo;

/**
 *
 * @author Jairo F
 */
public interface IRenta {
    void registrarVehiculo(Vehiculo v) throws IOException;
    Vehiculo buscarVehiculoPorPlaca(String placa) throws IOException;
    List<Vehiculo> listRentados() throws IOException;
}
