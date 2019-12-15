package Entities.Telas;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value="nylon")
public class Nylon extends Tela {

    public Nylon() {
        this.getPrendasIncompatibles().add("remera");
        this.getPrendasIncompatibles().add("sweater");
        this.getPrendasIncompatibles().add("zapatilla");
        this.getPrendasIncompatibles().add("zapato");
        this.getPrendasIncompatibles().add("sandalia");
        this.getPrendasIncompatibles().add("musculosa");

        setDescripcion("Nylon");
    }

    @Override
    public String toString() {
        return "Nylon";
    }
}
