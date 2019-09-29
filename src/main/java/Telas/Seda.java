package Telas;

import java.util.ArrayList;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value="seda")
public class Seda extends Tela {

    public Seda() {
        prendasIncompatibles = new ArrayList<>();
        prendasIncompatibles.add("campera");
        prendasIncompatibles.add("reloj");
        prendasIncompatibles.add("zapatilla");

    }
   /*
    @Override
    public Boolean incompatible(TipoPrenda tipoDePrenda){
        return ( tipoDePrenda.suTipo.equals("campera"));
    }
*/
   @Override
    public String toString() {
        return "Seda";
    }
}
