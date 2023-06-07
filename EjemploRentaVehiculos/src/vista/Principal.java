/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package vista;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import modelo.*;
import persistencia.ArchivoTexto;
import persistencia.IRenta;
import persistencia.ListVehiculo;
import persistencia.MapaVehiculo;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author morga
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        IRenta  listRentados = new ArchivoTexto();
        menuOpciones(listRentados);
    }
    
    public static void informeRenta(IRenta list) throws IOException {
        System.out.println("** INFORMES DE DEVOLUCION **");
        System.out.println("----------------------------");
        try {
            for (Vehiculo r : list.listRentados()) {
                devolucionVehiculo(r);
            }
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void menuOpciones(IRenta list) {

        int opc;
        try {
            do {

                System.out.println(" ** MENU DE OPCIONES **");
                System.out.println("1. Renta de vehiculo");
                System.out.println("2. Devolucion de vehiculo");
                System.out.println("3. Informe de rentas");
                System.out.println("4. Salir");
                System.out.println("");
                opc = Entrada.leerInt("Selecciones una opcion: ");
                switch (opc) {
                    case 1:
                        Vehiculo v = rentaVehiculo();
                        list.registrarVehiculo(v);
                        break;
                    case 2:
                        String placa = Entrada.leerString("Placa: ");
                        Vehiculo encontrado = buscarPorPlaca(placa, list);
                        if (encontrado == null) {
                            System.out.println("El Vehiculo no ha sido rentado.. ");
                        } else {
                            devolucionVehiculo(encontrado);
                        }
                        break;
                    case 3:
                        informeRenta(list);
                        break;
                    case 4:
                        System.out.println("Ha finalizado con exito");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opcion no disponible, seleccione nuevamente");
                }

            } while (true);
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }

    public static Vehiculo rentaVehiculo() {
        private static final DataTimeFormatter dateFormat = DataTimeFormatter.ofPattern("aaaa-mm-dd");
        Vehiculo v;
        System.out.println("----------------------------------------------------");
        String placa = Entrada.leerString("Placa: ");
        char tipoVehiculo = Entrada.leerchar("Tipo vehiculo[ A-> autobus, V->Automovil, X->Tractor ]: ");
        switch (tipoVehiculo) {
            case 'A':
            case 'a':
                double precioKm = Entrada.leerDouble("PrecioKm: ");
                double kmRenta = Entrada.leerDouble("Km renta: ");
                double kmDev = Entrada.leerDouble("Km dev: ");
                v = new Autobus(precioKm, kmRenta, kmDev, placa, true);
                break;
            case 'V':
            case 'v':
                int horasRenta = Entrada.leerInt("Horas renta: ");
                double valorHora = Entrada.leerDouble("Valor hora: ");
                v = new Automovil(valorHora, horasRenta, placa, true);
                break;
            default:
                double precioDia = Entrada.leerDouble("Precio dia: ");
                LocalDate fechaRenta = LocalDate.parse(Entrada.leerString("Fecha renta(aaaa-mm-dd): "), dateFormat);
                LocalDate fechaDev = LocalDate.parse(Entrada.leerString("Fecha devolucion(aaaa-mm-dd): "), dateFormat);
                v = new Tractor(precioDia, fechaRenta, fechaDev, placa, true);
                break;
        }

        return v;
    }

    public static Vehiculo buscarPorPlaca(String placa, IRenta list) throws IOException {

        return list.buscarVehiculoPorPlaca(placa);

    }

    public static void devolucionVehiculo(Vehiculo v) {

        v.setEstado(false);

//        if(v instanceof Autobus){
//           
//            Autobus a = (Autobus)v;
//            System.out.println("Km Renta: " + a.getKmRenta());
//            System.out.println("Km Devolucion: " + a.getKmDevolucion());
//            System.out.println("Precio Km: " + a.getPrecioKm());
//            
//        }
//        else{
//            
//            
//            System.out.println("Fecha renta: " +((Tractor)v).getFechaRenta().toString() );
//            System.out.println("Fecha devolucion: " +((Tractor)v).getFechaDevolucion().toString() );
//            System.out.println("Precio Dia: " + ((Tractor)v).getPrecioDia());
//        
//        }
        System.out.println(v);
        System.out.println("Total Importe: " + v.calcularImporteRenta());
        System.out.println("--------------------------------------------");

    }
    
}
