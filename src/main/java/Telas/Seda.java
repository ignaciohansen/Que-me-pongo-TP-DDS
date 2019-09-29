package Telas;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value="seda")
public class Seda extends Tela {

    public Seda() {
        this.getPrendasIncompatibles().add("campera");
        this.getPrendasIncompatibles().add("reloj");
        this.getPrendasIncompatibles().add("zapatilla");

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
