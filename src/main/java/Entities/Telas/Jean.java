package Entities.Telas;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value="jean")
public class Jean extends Tela {

    public Jean() {
        this.getPrendasIncompatibles().add("remera");
        this.getPrendasIncompatibles().add("sweater");
        this.getPrendasIncompatibles().add("campera");
        this.getPrendasIncompatibles().add("calza");
        this.getPrendasIncompatibles().add("buzo");
        this.getPrendasIncompatibles().add("zapatilla");
        this.getPrendasIncompatibles().add("zapato");
        this.getPrendasIncompatibles().add("sandalia");
        this.getPrendasIncompatibles().add("musculosa");

        setDescripcion("Jean");
    }

    @Override
    public String toString() {
        return "Jean";
    }
}


