package Entities.TipoPrenda;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value="pantalon")
public class Pantalon extends TipoPrenda {
    int nivelDeAbrigo = 5;
    private String suTipo = "pantalon";

    public Pantalon() {
        this.setNivelDeAbrigo(5);
        this.setSuTipo("pantalon");

    }
}
