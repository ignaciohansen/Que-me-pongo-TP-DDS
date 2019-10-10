package Entities.TipoPrenda;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value="pantufla")
public class Pantufla extends TipoPrenda {

    public Pantufla() {
        this.setNivelDeAbrigo(2);
        this.setSuTipo("pantufla");
    }
}
