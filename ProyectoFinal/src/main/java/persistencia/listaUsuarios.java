
package persistencia;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import model.*;

/**
 *
 * @author Jorman Noriega, Julio Rios, Andres Contreras, Sergio Arango
 */
public class listaUsuarios implements IRegistrar, Serializable {

    private List<Usuario> lista;

    public listaUsuarios() {
        this.lista = new ArrayList();
    }
    @Override
    public void registrarUsuario(Usuario u) {
        this.lista.add(u);       
    }

    @Override
    public Usuario buscarUsuario(String correo) {
        for (Usuario v : lista) {
            if (v.getCorreo().equalsIgnoreCase(correo)) {
                return v;
            }
        }
        return null;
    }

    @Override
    public List<Usuario> informeUsuarios() {
        return this.lista;
    }
    @Override
    public void registraIngreso(Ingreso i) throws IOException {   
    }
    @Override
    public void registraEgreso(Egreso e) throws IOException {   
    }
    
    
}

