package Entities.TipoPrenda;

import javax.persistence.*;
import javax.swing.*;

@Entity
@DiscriminatorValue(value="musculosa")
public class Musculosa extends TipoPrenda {

    public Musculosa() {
        this.setNivelDeAbrigo(3);
        this.setSuTipo("musculosa");
    }
}
