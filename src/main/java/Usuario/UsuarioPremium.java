package Usuario;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value="premium")
public class UsuarioPremium extends TipoUsuario{

	@Override
	public String toString() {
		return "UsuarioPremium";
	}
	
}