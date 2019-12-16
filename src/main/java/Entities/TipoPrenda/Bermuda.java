package Entities.TipoPrenda;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value="bermuda")
public class Bermuda extends TipoPrenda {

    public Bermuda() {
        this.setNivelDeAbrigo(3);
        this.setSuTipo("bermuda");

    }
}
