package Telas;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value="algodon")
public class Algodon extends Tela {
    public Algodon() {
        prendasIncompatibles.add("reloj");
        prendasIncompatibles.add("pantalon");
    }
}