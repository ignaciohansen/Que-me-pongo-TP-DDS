package Entities.TipoPrenda;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value= "sandalia")
public class Sandalia extends TipoPrenda {
    public Sandalia() {
        this.setNivelDeAbrigo(0);
        this.setSuTipo("sandalia");
    }
}
