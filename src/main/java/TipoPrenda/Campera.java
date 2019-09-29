package TipoPrenda;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value="campera")
public class Campera extends TipoPrenda {

    public Campera() {
        this.setNivelDeAbrigo(10);
        this.setSuTipo("campera");
        this.setCapaDePrenda(3);
    }
}