package Telas;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value="cuero")
public class Cuero extends Tela {

    public Cuero() {
        prendasIncompatibles.add("remera");
        prendasIncompatibles.add("camisa");
        prendasIncompatibles.add("gorro");
        prendasIncompatibles.add("guantes");
    }

    @Override
    public String toString() {
        return "Cuero";
    }
}

