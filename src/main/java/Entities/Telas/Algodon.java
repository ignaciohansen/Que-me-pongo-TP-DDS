package Entities.Telas;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value="algodon")
public class Algodon extends Tela {
    public Algodon() {
        this.getPrendasIncompatibles().add("reloj");
        this.getPrendasIncompatibles().add("pantalon");
    }

    @Override
    public String toString() {
        return "Algodon";
    }
}