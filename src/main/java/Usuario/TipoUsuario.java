package Usuario;

import Exceptions.SuperoLimiteDeGuardarropas;
import Ropas.Guardarropa;

import java.util.List;

public abstract class TipoUsuario {

    public void agregarGuardarropa(List<Guardarropa> guardarropas, Guardarropa guardarropa) throws SuperoLimiteDeGuardarropas {

        guardarropas.add(guardarropa);

    }

}