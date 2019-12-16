package Entities.TipoPrenda;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value="calza")
public class Calza extends TipoPrenda {
    int nivelDeAbrigo = 5;
    private String suTipo = "calza";

    public Calza() {
        this.setNivelDeAbrigo(5);
        this.setSuTipo("calza");

    }
}