package Entities.Telas;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value="seda")
public class Seda extends Tela {

    public Seda() {
        this.getPrendasIncompatibles().add("calza");
        this.getPrendasIncompatibles().add("buzo");
        this.getPrendasIncompatibles().add("zapatilla");
        this.getPrendasIncompatibles().add("musculosa");
        this.getPrendasIncompatibles().add("zapato");
        this.getPrendasIncompatibles().add("sandalia");
        setDescripcion("Seda");

    }

   @Override
    public String toString() {
        return "Seda";
    }
}
