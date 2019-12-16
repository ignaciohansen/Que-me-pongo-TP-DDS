package Entities.TipoPrenda;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value="pantalon_largo")
public class PantalonLargo extends TipoPrenda {
    int nivelDeAbrigo = 8;
    private String suTipo = "pantalon_largo";

    public PantalonLargo() {
        this.setNivelDeAbrigo(8);
        this.setSuTipo("pantalon_largo");

    }
}
