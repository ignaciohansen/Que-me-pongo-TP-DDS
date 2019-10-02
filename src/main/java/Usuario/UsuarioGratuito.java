package Usuario;

import Exceptions.SuperoLimiteDeGuardarropas;
import Ropas.Guardarropa;

import java.util.List;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value="gratuito")
public class UsuarioGratuito extends TipoUsuario {

	@Column(name="cant_maxima")
    int cantidadMaximaGuardarropas = 2;

    @Override
    public void agregarGuardarropa(List<Guardarropa> guardarropas, Guardarropa guardarropa) throws SuperoLimiteDeGuardarropas{
        if(cantidadMaximaGuardarropas > guardarropas.size()){
            guardarropas.add(guardarropa);
        }else{throw new SuperoLimiteDeGuardarropas();

        }

    }

	@Override
	public String toString() {
		return "UsuarioGratuito [cantidadMaximaGuardarropas=" + cantidadMaximaGuardarropas + "]";
	}
    
    
}
