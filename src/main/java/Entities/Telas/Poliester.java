package Entities.Telas;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value="poliester")
public class Poliester extends Tela {

    public Poliester() {
        this.getPrendasIncompatibles().add("musculosa");
        this.getPrendasIncompatibles().add("zapato");
        this.getPrendasIncompatibles().add("zapatilla");
        this.getPrendasIncompatibles().add("sandalia");
        setDescripcion("Poliester");

    }

    @Override
    public String toString() {
        return "Poliester";
    }
}