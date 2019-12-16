package Entities.TipoPrenda;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value="bermuda")
public class Bermuda extends TipoPrenda {
    int nivelDeAbrigo = 3;
    private String suTipo = "bermuda";

    public Bermuda() {
        this.setNivelDeAbrigo(3);
        this.setSuTipo("bermuda");

    }
}
