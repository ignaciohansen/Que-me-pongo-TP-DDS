package Entities.TipoPrenda;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value="calza")
public class Calza extends TipoPrenda {

    public Calza() {
        this.setNivelDeAbrigo(5);
        this.setSuTipo("calza");

    }
}