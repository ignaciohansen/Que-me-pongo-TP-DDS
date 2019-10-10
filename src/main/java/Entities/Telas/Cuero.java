package Entities.Telas;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value="cuero")
public class Cuero extends Tela {

    public Cuero() {
        this.getPrendasIncompatibles().add("remera");
        this.getPrendasIncompatibles().add("camisa");
        this.getPrendasIncompatibles().add("gorro");
        this.getPrendasIncompatibles().add("guantes");
    }

    @Override
    public String toString() {
        return "Cuero";
    }
}

