
package persistencia;

import java.io.IOException;
import java.util.List;
import model.*;


/**
 * @author Julio
 */
public interface IRegistrar {
    
    void registrarUsuario(Usuario u) throws IOException;
    void registraIngreso(Ingreso i) throws IOException;
    void registraEgreso(Egreso e) throws IOException;
    public Usuario buscarUsuario(String correo) throws IOException;
    public List<Usuario> informeUsuarios() throws IOException;
    
}
