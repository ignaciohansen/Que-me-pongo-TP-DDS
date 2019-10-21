package Entities.TipoPrenda;

import javax.persistence.*;
import javax.swing.*;

@Entity
@DiscriminatorValue(value="camisa")
public class Camisa extends TipoPrenda {

    public Camisa() {
        this.setNivelDeAbrigo(4);
        this.setSuTipo("camisa");
        this.setCapaDePrenda(2);
    }
}
