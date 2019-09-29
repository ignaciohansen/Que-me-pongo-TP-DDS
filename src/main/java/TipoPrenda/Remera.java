package TipoPrenda;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value="remera")
public class Remera extends TipoPrenda {

    public Remera() {
        this.setNivelDeAbrigo(5);
        this.setSuTipo("remera");
    }
}
