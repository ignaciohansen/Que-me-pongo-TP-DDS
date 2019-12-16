package Entities.TipoPrenda;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value="pantalon_corto")
public class PantalonCorto extends TipoPrenda {

    public PantalonCorto() {
        this.setNivelDeAbrigo(3);
        this.setSuTipo("pantalon_corto");

    }
}
