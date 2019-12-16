package Entities.TipoPrenda;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value="buzo")
public class Buzo extends TipoPrenda {

    public Buzo() {
        this.setNivelDeAbrigo(13);
        this.setSuTipo("buzo");
        this.setCapaDePrenda(2);
    }
}