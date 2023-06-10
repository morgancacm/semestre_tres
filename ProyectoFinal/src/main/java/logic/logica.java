package logic;

import java.io.IOException;
import java.util.List;
import model.*;
import persistencia.IRegistrar;
import persistencia.fileObjetos;

/**
 * @author Julio
 */
public class logica {

    private IRegistrar datos;

    public logica() {
        this.datos = new fileObjetos();
    }
    
    public void registrarUsuario(Usuario u)throws IOException{
        this.datos.registrarUsuario(u);
    }
    public void registrarIngreso(Ingreso i)throws IOException{
        this.datos.registraIngreso(i);
    }
    public void registrarEgreso(Egreso e)throws IOException{
        this.datos.registraEgreso(e);
    }
    
    public List<Usuario> informeUsuarios() throws IOException{
        return this.datos.informeUsuarios();
    }
    
    

}
