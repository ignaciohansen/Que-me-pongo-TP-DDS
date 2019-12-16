package Entities.TipoPrenda;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value="zapato")
public class Zapato extends TipoPrenda {
    public Zapato() {
        this.setNivelDeAbrigo(0);
        this.setSuTipo("zapato");
    }
}
