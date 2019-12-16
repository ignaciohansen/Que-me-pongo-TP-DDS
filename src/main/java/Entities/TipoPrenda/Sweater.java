package Entities.TipoPrenda;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value="sweater")
public class Sweater extends TipoPrenda {

    public Sweater() {
        this.setNivelDeAbrigo(15);
        this.setSuTipo("sweater");
        this.setCapaDePrenda(2);
    }
}