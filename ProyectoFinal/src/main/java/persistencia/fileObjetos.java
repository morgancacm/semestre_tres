
package persistencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import model.Egreso;
import model.Ingreso;
import model.Usuario;

/**
 * @author Jorman Noriega, Julio Rios, Andres Contreras, Sergio Arango
 */
public class fileObjetos implements IRegistrar{
    private File archivo;
    private FileInputStream aLectura;
    private FileOutputStream aEscritura;
    private listaUsuarios list;

    public fileObjetos() {
        this("DB.obj");
    }

    public fileObjetos(String name) {
        this.archivo = new File(name);
    }

    @Override
    public void registrarUsuario(Usuario u) throws IOException {
        this.leerLista();
        this.list.registrarUsuario(u);
    }

    @Override
    public void registraIngreso(Ingreso i) throws IOException {
        this.leerLista();
        this.list.registraIngreso(i);
    }

    @Override
    public void registraEgreso(Egreso e) throws IOException {
        this.leerLista();
        this.list.registraEgreso(e);
    }

    @Override
    public Usuario buscarUsuario(String correo) throws IOException {
        this.leerLista();
        //IMPLEMENTAR CODIGO PARA BUSCAR UN USUARIO DENTRO DE LA LISTA MEDIANTE SU CORREO
        return null;
    }

    @Override
    public List<Usuario> informeUsuarios() throws IOException {
        this.leerLista();
        return this.list.informeUsuarios();
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
            this.list = new listaUsuarios();
        } else {
            ObjectInputStream ois = null;
            try {
                this.aLectura = new FileInputStream(this.archivo);
                ois = new ObjectInputStream(this.aLectura);
                this.list = (listaUsuarios) ois.readObject();

            } catch (IOException ioe) {
                throw new IOException("EL ARCHIVO NO EXISTE O NO PUDO SER LEIDO");
            } catch (ClassNotFoundException ex) {
                throw new IOException("EL FORMATO DEL ARCHIVO NO ES CORRECTO, NO ES UNA LISTA DE USUARIOSS");
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
