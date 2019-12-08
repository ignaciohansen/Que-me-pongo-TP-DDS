package Entities.Usuario;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value="premium")
public class UsuarioPremium extends TipoUsuario{

	public UsuarioPremium() {
		this.setTipo("usuario premium");
	}

	@Override
	public String toString() {
		return "Usuario Premium";
	}
	
}