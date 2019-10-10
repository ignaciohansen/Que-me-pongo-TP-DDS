package Entities.TipoPrenda;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value="gorro")
public class Gorro extends Accesorio {


    public Gorro() {
        this.setSuTipo("gorro");
        this.setNivelDeAbrigo(3);
        this.setParteDelCuerpo(parteDelCuerpoQueAbriga.Cabeza);

    }
}