package Entities.TipoPrenda;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value="pollera")
public class Pollera extends TipoPrenda {
    int nivelDeAbrigo = 3;
    private String suTipo = "pollera";

    public Pollera() {
        this.setNivelDeAbrigo(3);
        this.setSuTipo("pollera");

    }
}