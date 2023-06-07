/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import modelo.Autobus;
import modelo.Tractor;
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
        this("Rentas.dat");
    }

    public ArchivoTexto(String name) {
        this.archivo = new File(name);
    }

    @Override
    public void registraVehiculo(Vehiculo v) throws IOException {

        try {
            this.aEscritura = new FileWriter(this.archivo, true);
            PrintWriter pw = new PrintWriter(this.aEscritura);
            pw.println(v.getDataFileFormat());
            pw.close();
        } catch (IOException ioe) {
            throw new IOException("El archivono existe o no pudo ser creado para escritura");

        } finally {
            if (this.aEscritura != null) {
                this.aEscritura.close();
            }
        }

    }

    
    private Vehiculo cargarDatos(String data[]){
        
        Vehiculo v=null;
        String placa = data[0];
        String tipo = data[1];
        if(tipo.equals("A")){
                double precioKm = Double.valueOf(data[2]);
                double Kmrenta = Double.valueOf(data[3]);
                double Kmdev = Double.valueOf(data[4]);
               
                v = new Autobus(precioKm, Kmrenta, Kmdev, placa, true); 
        }else{
                
               double precioDia = Double.valueOf(data[2]);
               LocalDate fechaRenta = LocalDate.parse(data[3]);
               LocalDate fechaDev = LocalDate.parse(data[4]);
               v= new Tractor(precioDia, fechaRenta, fechaDev, placa, true);
            
        }
        
        return v;
    }

    @Override
    public Vehiculo buscarVehiculo(String placa) throws IOException {
        try {
            this.aLectura = new Scanner(this.archivo);
            while(this.aLectura.hasNext()){
                String datos[] = this.aLectura.nextLine().split(";");
                Vehiculo v = this.cargarDatos(datos);
                if(v.getPlaca().equals(placa)){
                    return v;
                }
            
            }
            return null;
        } catch (FileNotFoundException fne) {

            throw new IOException("El archivo de lectura no existe o no es posible abrirlo");

        }finally{
            if(this.aLectura!=null)
                this.aLectura.close();
        }

    }

    @Override
    public List<Vehiculo> informeRenta() throws IOException {
        List<Vehiculo> rentados = new ArrayList();
        try {
            this.aLectura = new Scanner(this.archivo);
            while(this.aLectura.hasNext()){
                String datos[] = this.aLectura.nextLine().split(";");
                Vehiculo v = this.cargarDatos(datos);
                rentados.add(v);
            }
            return rentados;
        } catch (FileNotFoundException fne) {
           throw new IOException("El archivo de lectura no existe o no es posible abrirlo");

        }finally{
            if(this.aLectura!=null)
                this.aLectura.close();
        }
    }

}
