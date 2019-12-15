package Entities.Telas;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value="algodon")
public class Algodon extends Tela {
    public Algodon() {
        this.getPrendasIncompatibles().add("reloj");
        this.getPrendasIncompatibles().add("zapatilla");
        this.getPrendasIncompatibles().add("zapato");
        this.getPrendasIncompatibles().add("sandalia");
        setDescripcion("Algodon");
    }

    @Override
    public String toString() {
        return "Algodon";
    }
}