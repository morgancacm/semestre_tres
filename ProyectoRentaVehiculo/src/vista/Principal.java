/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package vista;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import logica.LogicRenta;
import modelo.*;

/**
 *
 * @author Jairo F
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        run(TipoVista.GUI);
        
         
    }

    public static void run(TipoVista vista){
        switch(vista){
            
            case CONSOLA: 
                          LogicRenta logica = new LogicRenta();
                          menuOpciones(logica);
                          break;
            case GUI:     
                          JFPrincipal principal = new JFPrincipal();
            
        }
    }
    
    
    public static void imprimirList(List<Vehiculo> list) {
        System.out.println("\n ** INFORME DE VEHICULOS RENTADOS ** ");
        for (Vehiculo v : list) {
            devolucionVehiculo(v);
        }

    }

    public static void devolucionVehiculo(Vehiculo v) {

        v.setEstado(false);

        System.out.println(v);
        System.out.println("Importe de renta: " + v.calcularImporteRenta());
        System.out.println("---------------------------------");

    }

    public static Vehiculo rentaVehiculo() {

        System.out.println("---------------------------------");
        Vehiculo v;
        String placa = Entrada.leerString("Placa:");
        char tipoVehiculo = Entrada.leerChar("Tipo [A->autobus, * ->tractor]: ");
        if (tipoVehiculo == 'A' || tipoVehiculo == 'a') {
            double precioKm = Entrada.leerDouble("Precio Km: ");
            double kmRenta = Entrada.leerDouble("Km renta: ");
            double kmDev = Entrada.leerDouble("Km devolucion: ");
            v = new Autobus(precioKm, kmRenta, kmDev, placa, true);
        } else {

            double precioDia = Entrada.leerDouble("Precio dia: ");
            LocalDate fechaRenta = LocalDate.parse(Entrada.leerString("Fecha renta(aaaa-mm-dd):  "));
            LocalDate fechaDevolucion = LocalDate.parse(Entrada.leerString("Fecha devolucion(aaaa-mm-dd): "));
            v = new Tractor(precioDia, fechaDevolucion, fechaRenta, placa, true);
        }

        return v;

    }

    public static void menuOpciones(LogicRenta logica) {
        int opc;
        try {
            do {

                System.out.println("     **   MENU DE OPCIONES **     ");
                System.out.println("1. Renta de vehiculo");
                System.out.println("2. Devolucion de vehiculo");
                System.out.println("3. Informe de rentas");
                System.out.println("4. Salir");

                opc = Entrada.leerInt("Selecciones su opcion: ");
                switch (opc) {

                    case 1:
                        Vehiculo v = rentaVehiculo();
                        logica.rentarVehiculo(v);
                        break;
                    case 2:
                        String placa = Entrada.leerString("Placa a buscar: ");
                        Vehiculo r = logica.buscarRentado(placa);
                        if (r == null) {
                            System.out.println("EL vehiculo no esta rentado o no existe");
                        } else {
                            devolucionVehiculo(r);
                        }
                        break;
                    case 3:
                        imprimirList(logica.informeRentas());
                        break;
                    case 4:
                        System.out.println("Salida exitosa....");
//                    System.exit(0);
                        break;
                    default:
                        System.out.println("opcion no disponible");

                }

            } while (opc != 4);
        } catch (IOException ioe) {

            System.out.println(ioe);
        }

    }

}
