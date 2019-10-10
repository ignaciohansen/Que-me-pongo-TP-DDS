package Entities.TipoPrenda;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value="reloj")
public class Reloj extends Accesorio {


    public Reloj() {
        this.setSuTipo("reloj");
        this.setParteDelCuerpo(parteDelCuerpoQueAbriga.Ninguna);

    }
}
