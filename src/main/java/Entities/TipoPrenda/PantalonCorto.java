package Entities.TipoPrenda;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value="pantalon_corto")
public class PantalonCorto extends TipoPrenda {
    int nivelDeAbrigo = 5;
    private String suTipo = "pantalon_corto";

    public PantalonCorto() {
        this.setNivelDeAbrigo(3);
        this.setSuTipo("pantalon_corto");

    }
}
