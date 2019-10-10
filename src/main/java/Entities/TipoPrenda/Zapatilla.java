package Entities.TipoPrenda;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value="zapatilla")
public class Zapatilla extends TipoPrenda {
    public Zapatilla() {
        this.setNivelDeAbrigo(3);
        this.setSuTipo("zapatilla");
    }
}
