package Entities.TipoPrenda;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value="campera")
public class Campera extends TipoPrenda {

    public Campera() {
        this.setNivelDeAbrigo(13);
        this.setSuTipo("campera");
        this.setCapaDePrenda(3);
    }
}