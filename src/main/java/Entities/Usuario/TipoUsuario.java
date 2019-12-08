package Entities.Usuario;

import Entities.Exceptions.SuperoLimiteDeGuardarropas;
import Entities.Ropas.Guardarropa;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="TIPO_USUARIO")
@Inheritance (strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo", discriminatorType = DiscriminatorType.STRING)
public abstract class TipoUsuario {
	
	@Id
	@GeneratedValue
	@Column(name="tipo_usu_id")
	protected long id;


	@Column(name="tipo_usuario_descripcion")
	private String tipo;

    public void agregarGuardarropa(List<Guardarropa> guardarropas,Guardarropa guardarropa) throws SuperoLimiteDeGuardarropas {

        guardarropas.add(guardarropa);

    }

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


}