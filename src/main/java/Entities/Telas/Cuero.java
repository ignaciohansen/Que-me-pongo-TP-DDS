package Entities.Telas;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value="cuero")
public class Cuero extends Tela {

    public Cuero() {
        this.getPrendasIncompatibles().add("remera");
        this.getPrendasIncompatibles().add("sweater");
        this.getPrendasIncompatibles().add("campera");
        this.getPrendasIncompatibles().add("pantalon");
        this.getPrendasIncompatibles().add("bermuda");
        this.getPrendasIncompatibles().add("pollera");
        this.getPrendasIncompatibles().add("calza");
        this.getPrendasIncompatibles().add("buzo");
        this.getPrendasIncompatibles().add("musculosa");

        setDescripcion("Cuero");
    }

    @Override
    public String toString() {
        return "Cuero";
    }
}

