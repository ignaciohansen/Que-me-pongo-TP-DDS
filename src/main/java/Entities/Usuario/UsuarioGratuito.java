package Entities.Usuario;

import Entities.Exceptions.SuperoLimiteDeGuardarropas;
import Entities.Ropas.Guardarropa;

import java.util.List;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value="gratuito")
public class UsuarioGratuito extends TipoUsuario {

	@Column(name="cant_maxima")
    int cantidadMaximaGuardarropas = 2;

    public UsuarioGratuito() {
        this.setTipo("usuario gratuito");
    }

    @Override
    public void agregarGuardarropa(List<Guardarropa> guardarropas, Guardarropa guardarropa) throws SuperoLimiteDeGuardarropas{
        if(cantidadMaximaGuardarropas > guardarropas.size()){
            guardarropas.add(guardarropa);
        }else{throw new SuperoLimiteDeGuardarropas();

        }

    }

	@Override
	public String toString() {
        return "Usuario Gratuito";
		//return "UsuarioGratuito [cantidadMaximaGuardarropas=" + cantidadMaximaGuardarropas + "]";
	}
    
    
}
