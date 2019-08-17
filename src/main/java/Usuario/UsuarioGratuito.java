package Usuario;

import Exceptions.SuperoLimiteDeGuardarropas;
import Ropas.Guardarropa;

import java.util.List;

public class  UsuarioGratuito extends TipoUsuario {

    int cantidadMaximaGuardarropas = 2;

    @Override
    public void agregarGuardarropa(List<Guardarropa> guardarropas, Guardarropa guardarropa) throws SuperoLimiteDeGuardarropas{
        if(cantidadMaximaGuardarropas > guardarropas.size()){
            guardarropas.add(guardarropa);
        }else{throw new SuperoLimiteDeGuardarropas();

        }

    }
}
