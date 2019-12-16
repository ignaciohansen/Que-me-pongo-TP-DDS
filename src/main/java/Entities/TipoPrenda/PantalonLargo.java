package Entities.TipoPrenda;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value="pantalon_largo")
public class PantalonLargo extends TipoPrenda {

    public PantalonLargo() {
        this.setNivelDeAbrigo(8);
        this.setSuTipo("pantalon_largo");

    }
}
