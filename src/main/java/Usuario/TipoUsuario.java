package Usuario;

import Exceptions.SuperoLimiteDeGuardarropas;
import Ropas.Guardarropa;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="TIPO_USUARIO")
@Inheritance (strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo", discriminatorType = DiscriminatorType.STRING)
public abstract class TipoUsuario {
	
	@Id
	@Column(name="tipo_usu_id")
	protected long id;

    public void agregarGuardarropa(List<Guardarropa> guardarropas,Guardarropa guardarropa) throws SuperoLimiteDeGuardarropas {

        guardarropas.add(guardarropa);

    }

}