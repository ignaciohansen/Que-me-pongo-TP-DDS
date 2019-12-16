package Entities.Telas;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value="lycra")
public class Lycra extends Tela {

    public Lycra() {
        this.getPrendasIncompatibles().add("sweater");
        this.getPrendasIncompatibles().add("campera");
        this.getPrendasIncompatibles().add("pantalon_corto");
        this.getPrendasIncompatibles().add("pantalon_largo");
        this.getPrendasIncompatibles().add("bermuda");
        this.getPrendasIncompatibles().add("pollera");
        this.getPrendasIncompatibles().add("zapatilla");
        this.getPrendasIncompatibles().add("zapato");
        this.getPrendasIncompatibles().add("sandalia");
        setDescripcion("Lycra");
    }

    @Override
    public String toString() {
        return "Lycra";
    }
}

