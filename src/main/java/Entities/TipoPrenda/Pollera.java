package Entities.TipoPrenda;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value="pollera")
public class Pollera extends TipoPrenda {

    public Pollera() {
        this.setNivelDeAbrigo(3);
        this.setSuTipo("pollera");

    }
}