/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import modelo.Autobus;
import modelo.Vehiculo;

/**
 *
 * @author Jairo F
 */
public class ArchivoTexto implements IRenta {

    private File archivo;
    private FileWriter aEscritura;
    private Scanner aLectura;

    public ArchivoTexto() {
        this("rentas.dat");
    }

    public ArchivoTexto(String name) {
        this.archivo = new File(name);
    }

    @Override
    public void registrarVehiculo(Vehiculo v) throws IOException {
        try {
            this.aEscritura = new FileWriter(this.archivo, true);
            PrintWriter pw = new PrintWriter(this.aEscritura);
            pw.println(v.getDataFileFormat());
            pw.close();

        } catch (IOException ioe) {
            throw new IOException("El archivo de escritura no existe o no pudo ser creado");
        } finally {
            if (this.aEscritura != null) {
                this.aEscritura.close();
            }
        }
    }

    @Override
    public Vehiculo buscarVehiculoPorPlaca(String placa) throws IOException {
        Vehiculo encontrado = null;
        try {
            this.aLectura = new Scanner(this.archivo);
            while (this.aLectura.hasNext()) {
                String data[] = this.aLectura.nextLine().split(";");
                Vehiculo v = this.cargarDatos(data);
                if(v.getPlaca().equals(placa)){
                    encontrado = v;
                    break;
                }
            }
            return encontrado;
        } catch (IOException ioe) {
          throw new IOException("El archivo de lectura no existe o no puede ser leido");

        }
        finally{
            if(this.aLectura!=null)
                this.aLectura.close();
        }
    }

    private Vehiculo cargarDatos(String[] data) {
        Vehiculo v = null;
        String placa = data[0];
        String tipo = data[1];
        if (tipo.equalsIgnoreCase("A")) {
            double precioKm = Double.valueOf(data[2]);
            double kmRenta = Double.valueOf(data[3]);
            double kmDev = Double.valueOf(data[4]);
            v = new Autobus(precioKm, kmRenta, kmDev, placa, true);
        } else if (tipo.equalsIgnoreCase("T")) {
            
        } else {

        }
        return v;
    }

    @Override
    public List<Vehiculo> listRentados() throws IOException {
        List<Vehiculo> lista = new ArrayList();
        try {
            this.aLectura = new Scanner(this.archivo);
            while (this.aLectura.hasNext()) {
                String data[] = this.aLectura.nextLine().split(";");
                Vehiculo v = this.cargarDatos(data);
                lista.add(v);
            }
            return lista;
        } catch (IOException ioe) {
            throw new IOException("El archivo de lectura no existe o no puede ser leido");

        }
        finally{
            if(this.aLectura!=null)
                this.aLectura.close();
        }

    }

}
