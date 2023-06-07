/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.io.*;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Vehiculo;

/**
 *
 * @author Jairo F
 */
public class ArchivoObjetos implements IRenta {

    private File archivo;
    private FileInputStream aLectura;
    private FileOutputStream aEscritura;
    private ListaVehiculo list;

    public ArchivoObjetos() {
        this("rentas.obj");
    }

    public ArchivoObjetos(String name) {
        this.archivo = new File(name);
    }

    @Override
    public void registraVehiculo(Vehiculo v) throws IOException {
            this.leerLista();
            this.list.registraVehiculo(v);
            this.guardarLista();
    }

    @Override
    public Vehiculo buscarVehiculo(String placa) throws IOException {
        this.leerLista();
        return this.list.buscarVehiculo(placa);

    }

    @Override
    public List<Vehiculo> informeRenta() throws IOException {
        this.leerLista();
        return this.list.informeRenta();
    }

    private void guardarLista() throws IOException {
        ObjectOutputStream oos = null;
        try {
            this.aEscritura = new FileOutputStream(this.archivo);
            oos = new ObjectOutputStream(this.aEscritura);
            oos.writeObject(this.list);

        } catch (IOException ioe) {
            throw new IOException("No es posible crear el archivo para escritura");
        } finally {
            if (oos != null) {
                oos.close();
            }
            if (this.aEscritura != null) {
                this.aEscritura.close();
            }
        }

    }

    private void leerLista() throws IOException {

        if (!this.archivo.exists()) {
            this.list = new ListaVehiculo();
        } else {
            ObjectInputStream ois = null;
            try {
                this.aLectura = new FileInputStream(this.archivo);
                ois = new ObjectInputStream(this.aLectura);
                this.list = (ListaVehiculo) ois.readObject();

            } catch (IOException ioe) {
                throw new IOException("El archivo no existe o no pudo ser leido");
            } catch (ClassNotFoundException ex) {
                throw new IOException("El formato del archivo no es correcto, no es una lista de vehiculo");
            } finally {
                if (ois != null) {
                    ois.close();
                }
                if (this.aLectura != null) {
                    this.aLectura.close();
                }

            }
        }
    }

}
